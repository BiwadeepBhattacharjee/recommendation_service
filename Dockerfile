FROM openjdk:11
ADD ./target/Recommendation-Service-0.0.1-SNAPSHOT.jar /usr/src/Recommendation-Service-0.0.1-SNAPSHOT.jar
EXPOSE 8095
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "Recommendation-Service-0.0.1-SNAPSHOT.jar"]