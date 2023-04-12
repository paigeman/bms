FROM tomcat:10.0.21-jdk17-corretto
LABEL authors="fade"
WORKDIR /usr/local/tomcat/webapps
ADD bms.war .
RUN mv target/bms.war ROOT.war