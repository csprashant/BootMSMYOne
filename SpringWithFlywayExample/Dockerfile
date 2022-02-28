FROM openjdk:11
EXPOSE 8080
ADD target/docker-api.jar docker-api.jar
ENTRYPOINT ["java","-jar","/docker-api.jar"]