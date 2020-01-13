FROM openjdk:8-jdk-alpine
MAINTAINER charlesdccti@gmail.com
VOLUME /tmp
EXPOSE 8080
ADD build/libs/contact-service-gradle-backend-0.0.1-SNAPSHOT.jar springbootpostgresqldocker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springbootpostgresqldocker.jar"]