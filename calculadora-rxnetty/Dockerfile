FROM ubuntu:latest

MAINTAINER Eduarda Correia Ferreira "eduarda.ferreira@ilegra.com"

EXPOSE 8080

RUN apt-get update && \
apt-get install -y openjdk-8-jdk && \
apt-get install -y wget && \
mkdir /home/tomcat && \
wget http://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.19/bin/apache-tomcat-9.0.19.tar.gz && \
tar -xvzf apache-tomcat-9.0.19.tar.gz && mv apache-tomcat-9.0.19 /home/tomcat/ && \
apt-get clean

COPY ./build/libs/Tema6.war /usr/local/tomcat/webapps/calculadora.war
