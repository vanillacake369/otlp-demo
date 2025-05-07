# Build Stage
FROM gradle:8.6-jdk17 AS builder
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src src
RUN gradle assemble

# Runtime Stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
ENTRYPOINT ["java", "-jar", "app.jar"]
# Java Agent
# RUN apt-get install -y curl
# RUN curl --fail --show-error --location -o opentelemetry-javaagent.jar https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
# ENTRYPOINT ["java", "-javaagent:opentelemetry-javaagent.jar", "-jar", "app.jar"]