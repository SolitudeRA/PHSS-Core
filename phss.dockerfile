FROM ubuntu:18.04
LABEL maintainer="solitude@protogalaxy.me"

RUN apt-get update && apt-get -y install openjdk-8-jdk

RUN apt-get update && apt-get -y install mysql-server mysql-client \
&& mysql -u debian-sys-maint -p $(cat /etc/mysql/debian.cnf | grep -E -o -m 1 '\w{16}') << EOF\
use mysql;\
update user set authentication_string=PASSWORD("root") where user='root';\
update user set plugin="mysql_native_password";\
flush privileges;\
create database protogalaxy;\
EOF

RUN apt-get update && apt-get -y install nginx