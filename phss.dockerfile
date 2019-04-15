FROM ubuntu:18.04
LABEL maintainer="solitude@protogalaxy.me"

RUN apt-get update && apt-get -y install openjdk-8-jdk

RUN apt-get update && apt-get -y install mysql-server mysql-client

RUN apt-get update && apt-get -y install nginx