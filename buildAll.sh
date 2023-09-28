#!/bin/zsh
cd api1/
mvn clean package -DskipTests
cd ..
pwd
cd api2/
mvn clean package -DskipTests
cd ..
pwd
cd apigateway/
mvn clean package -DskipTests
cd ..
pwd
docker-compose up --build --force-recreate