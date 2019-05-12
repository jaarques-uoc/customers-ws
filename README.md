# customers-ws [![Build Status](https://travis-ci.com/jaarques-uoc/customers-ws.svg?branch=master)](https://travis-ci.com/jaarques-uoc/customers-ws)

Command line tools:
* Mongodb:
    * Installation:
        * `brew tap mongodb/brew`
        * `brew install mongodb-community@4.0`
    * Start: `mongod --config /usr/local/etc/mongod.conf`
* Spring boot:
    * build: `./gradlew build`
    * run: `./gradlew bootRun`
* Docker:
    * build: `docker build --tag=customers-ws .`
    * run: `docker run -p 7001:8080 -t customers-ws`
    * stop: `docker stop $(docker ps -q --filter ancestor=customers-ws)`
    * stop all containers: `docker stop $(docker ps -a -q)`

* Urls:
    * Travis CI history: https://travis-ci.com/jaarques-uoc/customers-ws/
    * Docker image: https://cloud.docker.com/repository/docker/jaarquesuoc/customers-ws
    * Heroku app health-check: https://customers-ws.herokuapp.com/actuator/health