FROM image-base
EXPOSE 8083
ADD target/login-service.jar login-service.jar 
ENTRYPOINT [ "java","-jar","/login-service.jar" ]