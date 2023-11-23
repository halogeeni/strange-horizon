FROM maven:3-eclipse-temurin-17 AS builder

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jdk

COPY --from=builder /home/app/target/strange-horizon-api-1.0-SNAPSHOT.jar /usr/local/lib/api.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/usr/local/lib/api.jar"]
