# ---------- build stage ----------
FROM eclipse-temurin:8-jdk AS builder
WORKDIR /app

# Copy gradle wrapper and build scripts first (better caching)
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# Copy source
COPY src ./src

# Build jar
RUN chmod +x ./gradlew && ./gradlew clean build -x test

# ---------- runtime stage ----------
FROM eclipse-temurin:8-jre
WORKDIR /app

# Copy the built jar (Spring Boot default)
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]