FROM ubuntu:18.04
LABEL maintainer="solitude@protogalaxy.me"

RUN apt-get update && apt-get install -Y openjdk-8-jdk

RUN apt-get install -Y mysql-server mysql-client \
&& default_password=$(cat /etc/mysql/debian.cnf | grep -E -o -m 1 '\w{16}') \
&& mysql -u root -p $default_password << EOF \
use mysql; \
update user set authentication_string=PASSWORD("root") where user='root'; \
update user set plugin="mysql_native_password"; \
flush privileges; \
create database protogalaxy; \
EOF 

RUN apt-get -Y install nginx