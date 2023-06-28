FROM openjdk:11
EXPOSE 9006
ADD target/telemedicine-consultation-image.jar telemedicine-consultation-image.jar
ENTRYPOINT ["java","-jar","/telemedicine-consultation-image.jar"]