#stage-1 for maven
FROM maven:3.8.3 AS builder
WORKDIR /opt/Caddy_Test
COPY . .
RUN mvn clean install

#stage-2 for java server
FROM openjdk:17
MAINTAINER kaungminkhant
WORKDIR /opt/Caddy_Test
COPY --from=builder /opt/Caddy_Test/target/Caddy_Test-1.0-SNAPSHOT.jar /app.jar
EXPOSE 8080
CMD ["java","-jar","/app.jar"]
