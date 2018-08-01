# 虚拟机说明文档
虚拟机系统 centos7 64位
账号 root
密码 123456
#### 包括软件
* docker 1.13.1
* jdk 1.8.0_144
* nginx 1.15.1
* mysql 8.0.11
* redis 4.0.10
* docker 1.13.1

##### docker
* 安装 yum -y install docker-io
* 启动 systemctl start docker.service

##### jdk T
* 路径 /usr/local/jdk1.8.0_65
* 安装说明  https://www.cnblogs.com/xuliangxing/p/7066913.html

##### nginx T
* 路径 /usr/local/nginx
* 启动 nginx
* 重启 nginx -s reload

##### mysql T
* 配置 /etc/my.conf****
* 账号 root
* 密码 Dwx@940217
* 端口 3306
* 启动 systemctl start mysqld
* 停止 systemctl stop mysqld
* 修改密码 set password for root@localhost = password('新密码');  

##### redis 开机自启动
* 路径 /usr/local/redis/redis-4.0.10
* 配置 /etc/init.d/redis-auto
* 端口 6379
* 启动 service redis-auto start
* 停止 service redis-auto stop

#### zookeeper 开机自启动
* 路径 /usr/local/zookeeper
* 配置 /etc/init.d/zookeeper




