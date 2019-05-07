# customers-service [![Build Status](https://travis-ci.com/jaarques-uoc/customers-service.svg?branch=master)](https://travis-ci.com/jaarques-uoc/customers-service)

Command line tools:
* Spring boot:
    * build: `./gradlew build`
    * run: `./gradlew bootRun`
* Docker:
    * build: `docker build --tag=customers .`
    * run: `docker run -p 7001:8080 -t customers`
    * stop: `docker stop $(docker ps -q --filter ancestor=customers)`
    * stop all containers: `docker stop $(docker ps -a -q)`

* Urls:
    * Travis CI history: https://travis-ci.com/jaarques-uoc/customers-service/
    * Docker image: https://cloud.docker.com/repository/docker/jaarquesuoc/customers-service
    * Heroku app health-check: https://customers-service.herokuapp.com/actuator/health