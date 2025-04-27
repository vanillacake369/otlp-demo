# Build Stage
FROM gradle:8.6-jdk17 AS builder
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src src
RUN gradle assemble

# Runtime Stage
FROM eclipse-temurin:17-jre
WORKDIR /app
RUN apt-get update && apt-get install -y \
    build-essential \
    curl
RUN curl -o opentelemetry-javaagent.jar https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
COPY --from=builder /app/build/libs/*.jar app.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "app.jar"]