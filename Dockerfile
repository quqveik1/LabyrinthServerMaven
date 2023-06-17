# Используйте официальный образ Java Runtime Environment (JRE)
FROM openjdk:8-jre-alpine

# Создайте директорию для приложения в контейнере
WORKDIR /app

# Скопируйте .jar файл в созданную директорию
COPY ./target/your-app.jar /app/your-app.jar

# Запустите приложение при старте контейнера
CMD ["java", "-jar", "/app/your-app.jar"]