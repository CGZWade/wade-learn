<template>
    <div>
        {{name}}
    </div>
</template>

<script>
    export default {
        name: 'HelloWorld',
        data() {
            return {
                msg: 'Welcome to Your Vue.js App',
                name: ''
            }
        },
        mounted() {
            this.query()
        },
        methods: {
            async query() {
                const that = this
                const res = await that.$axios.get('http://127.0.0.1:8002/hello/cgz')
                this.name =res.data.name
            },
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    h1, h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }
</style>
