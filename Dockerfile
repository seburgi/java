FROM gradle:jdk17 AS builder
ENV GRADLE_OPTS=-Dorg.gradle.daemon=false

WORKDIR /app

COPY build.gradle settings.gradle /app/
RUN gradle build -x test || return 0

COPY . .
RUN gradle clean build -x test

#########################

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/build/libs/app.jar .

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
