FROM openjdk:11
ARG JAR_FILE=target/*.jar
MAINTAINER "Petzi"
COPY target/*.jar petziferum/backend.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","petziferum/backend.jar"]


