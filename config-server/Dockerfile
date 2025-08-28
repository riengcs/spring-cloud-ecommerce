# STAGE 1: BUILD
FROM maven:3.9.11-eclipse-temurin-21-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn/ .mvn/
COPY src ./src
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
RUN ./mvnw clean package -DskipTests

# STAGE 2: RUN
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
COPY --chown=appuser:appgroup --from=builder /app/target/*.jar app.jar
USER appuser
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]
