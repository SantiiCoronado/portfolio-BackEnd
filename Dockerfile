FROM amazoncorretto:19-alpine-jdk

COPY target/backend-0.0.1-SNAPSHOT.jar backend.jar

ENTRYPOINT ["java","-jar","/backend.jar"]