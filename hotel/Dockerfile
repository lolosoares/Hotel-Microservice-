FROM openjdk:17-jdk-slim
EXPOSE 8081
ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT [ "java","-jar","/spring-boot-docker.jar" ]