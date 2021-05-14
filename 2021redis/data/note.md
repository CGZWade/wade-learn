# Redis

MyISAM：表锁
InnoDB：行锁

键值型数据库
文档型数据库
列存储数据库
图关系数据库


一、docker安装reids
1. 拉取：docker pull redis:latest

2. 运行容器：docker run -itd --name redis-test -p 6379:6379 redis

3.  通过 redis-cli 连接：docker exec -it redis-test /bin/bash

   进入后：redis-cli

