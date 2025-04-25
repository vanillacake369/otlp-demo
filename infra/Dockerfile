# Build Stage
FROM gradle:8.6-jdk17 AS builder
#FROM arm64v8/gradle:8.6-jdk17 AS builder
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src src
RUN gradle assemble

# Runtime Stage
FROM eclipse-temurin:17-jre
#FROM arm64v8/eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime