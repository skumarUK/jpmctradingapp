# JPMC Daily Trade Reporting Engine Interview Test Exercise

JPMC Daily Trading Reporting Engine collects all the trading instructions requested in form of json format file.

## Tech Spec
    - jdk1.8.0_131
    - Maven

## 3rd party API Used
    - Google Gson  - Json Parsing
    - JUnit - Unit Testing

## Build using JDK 8

## Build usind Maven which will build and generate artifacts.

    - sudo mvn clean package

## Run Daily Trading Report

    - java -jar tradereporting-1.0-SNAPSHOT-jar-with-dependencies.jar

## Build docker Image

    - sudo mvn clean package docker:build
    
## Run Daily Trading Report Using Docker Image

    - sudo docker-compose up
    

