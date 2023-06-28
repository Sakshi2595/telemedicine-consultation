FROM openjdk:11
EXPOSE 9006
ADD target/event-repo-image.jar event-repo-image.jar
ENTRYPOINT ["java","-jar","/event-repo-image.jar"]