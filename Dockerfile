FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

FROM openjdk:17-jdk-slim
WORKDIR weather-app-demo
COPY --from=build target/*.jar weather-app-demo.jar
ENTRYPOINT ["java", "-jar", "weather-app-demo.jar"]