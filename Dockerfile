FROM openjdk:11
ARG JAR_FILE=target/*.jar
MAINTAINER "Petzi"
COPY target/*.jar petziferum/backend.jar
EXPOSE 8010
ENTRYPOINT ["java","-jar","petziferum/backend.jar"]


