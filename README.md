# customers-service

Command line tools:
* Spring boot:
    * build: `./gradlew build`
    * run: `./gradlew bootRun`
* Docker:
    * build: `docker build --tag=customers .`
    * run: `docker run -p 8080:8080 -t customers`
    * stop: `docker stop $(docker ps -q --filter ancestor=customers)`
    * stop all containers: `docker stop $(docker ps -a -q)`