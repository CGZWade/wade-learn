import Vue from "vue";
import axios from "axios";
import qs from "qs";
import ElementUI from "element-ui";

axios.defaults.transformRequest = [function (data) {
    if (window.FormData !== undefined) {
        if (data instanceof FormData) {
            return data;
        }
    }
    return qs.stringify(data, {skipNulls: true, strictNullHandling: true});
}];

axios.interceptors.request.use(
    config => {
        const timestamp = new Date().getTime();
        config.headers.Timestamp = timestamp;

        let dic = {};
        if (config.method === "get") {
            if (config.params) {
                dic = config.params || {};
                dic.time = new Date().getTime();
            } else {
                if (config.url.indexOf("?") > -1) {
                    config.url = `${config.url}&time=${new Date().getTime()}`;
                    dic = qs.parse(config.url.split("?")[1], {skipNulls: true, strictNullHandling: true}) || {};
                } else {
                    config.url = `${config.url}?time=${new Date().getTime()}`;
                }
            }
        } else {
            dic = config.data || {};
        }
        dic.timestamp = timestamp;
        const sdic = Object.keys(dic).sort();
        let query = "";
        for (const ki in sdic) {
            if (dic[sdic[ki]] === "" || dic[sdic[ki]] == null) {
                delete dic[sdic[ki]];
            } else {
                query = `${query + sdic[ki]}=${dic[sdic[ki]]}&`;
            }
        }

        delete dic.timestamp;

        if (config.url.indexOf("?") !== -1) {
            const arr = Object.keys(dic);
            if (arr.length === 0) {
                config.url = config.url.split("?")[0];
            } else {
                config.url = `${config.url.split("?")[0]}?${qs.stringify(dic, {skipNulls: true, strictNullHandling: true})}`;
            }
        }
        return config;
    }, (error) => {
        return Promise.reject(error);
    }
);

axios.interceptors.response.use((response) => {
    if (response.data.code === 402 || response.data.code === 10000) {
        localStorage.clear();
        router.replace({
            path: "/login",
            query: {redirect: router.currentRoute.fullPath}
        });
    } else if (response.data.code === 404) {
        ElementUI.Message.error({showClose: true, message: response.data.message, duration: 2000});
    } else if (response.data.code === 500) {
        ElementUI.Message.error({showClose: true, message: response.data.message, duration: 2000});
    }

    return response;
}, (error) => {
    ElementUI.Message.error({showClose: true, message: "系统繁忙，请稍后再试", duration: 2000});
    return Promise.reject(error);
});

Vue.prototype.$axios = axios;
