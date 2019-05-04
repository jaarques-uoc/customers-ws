FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/customers-0.0.1-SNAPSHOT.jar customers-0.0.1-SNAPSHOT.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customers-0.0.1-SNAPSHOT.jar"]