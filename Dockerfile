# 1. Java 8 (OpenJDK 8) 베이스 이미지 사용
FROM eclipse-temurin:8-jdk-alpine

# 2. 컨테이너 내 작업 디렉토리 설정
WORKDIR /app

# 3. 빌드된 jar 파일을 컨테이너로 복사
# Gradle 빌드 후 생성되는 jar 파일명을 확인해주세요.
COPY build/libs/*.jar app.jar

# 4. 앱 실행
ENTRYPOINT ["java", "-jar", "app.jar"]