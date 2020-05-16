FROM ubuntu 18.04

MAINTAINER Eduarda Correia Ferreira "eduarda.ferreira@ilegra.com"

EXPOSE 8080

RUN apt-get update && \
apt-get install -y openjdk-8-jdk && \
apt-get install -y wget && \
mkdir /usr/tomcat && \
wget http://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.19/bin/apache-tomcat-9.0.19.tar.gz && \
tar -xvzf apache-tomcat-9.0.19.tar.gz && mv apache-tomcat-9.0.19 /usr/tomcat/ && \
apt-get clean

COPY ./build/libs/tema-6-Docker-1.0-SNAPSHOT.war /usr/tomcat/apache-tomcat9/webapps/

CMD /usr/tomcat/apache-tomcat-9.0.19/bin/catalina.sh run
