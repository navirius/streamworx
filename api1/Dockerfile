# Docker file for the Read Service
#
# Version 0.0.1

#jdk image
FROM maven:3.6.3-adoptopenjdk-11

WORKDIR /home/app
#workarund to disable cache 
RUN rm -r /home/app

#COPY . /home/app
#RUN ls --recursive /home/app
#RUN mvn -f /home/app/pom.xml clean package -DskipTests
EXPOSE 9595
ARG VERSION=0.0.1

COPY target/api1-${VERSION}-SNAPSHOT.jar /home/app/app.jar

# label for the image
LABEL Description="API1 Server" Version="0.0.1"

# the version of the archive

# mount the temp volume
#VOLUME /tmp

# Add the service as app.jar
#ADD apigateway-${VERSION}-SNAPSHOT.jar app.jar

# entrypoint to the image on run
ENTRYPOINT ["java","-jar","/home/app/app.jar"]