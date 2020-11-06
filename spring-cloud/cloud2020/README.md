# wade-learn

### SpringCloud学习网址

https://www.bilibili.com/video/BV18E411x7eT

### docker安装consul

1. 获取consul镜像：docker pull consul
2. Docker运行consul：docker run --name consule -d -p 8500:8500 -p 8600:8600/udp consul
3. 访问管理页面：http://127.0.0.1:8500/ui

### CAP

1. C：Consistency（强一致性）
2. A：Availability（可用性）
3. P：Partition Tolerance（分区容错）
4. CAP理论关注粒度是数据，而不是整体系统设计的策略

5. 三者选其二

   AP：Eureka

   CP：Zookeeper、Consul



### Ribbon

1.  已经结合在eureka中

