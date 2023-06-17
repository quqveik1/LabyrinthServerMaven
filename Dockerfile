# Используйте официальный образ Java Runtime Environment (JRE)
FROM openjdk:17-jre-alpine

# Создайте директорию для приложения в контейнере
WORKDIR /app

# Скопируйте .jar файл в созданную директорию
COPY ./target/LabyrinthServer-0.0.1-SNAPSHOT.jar /app/your-app.jar

# Запустите приложение при старте контейнера
CMD ["java", "-jar", "/app/your-app.jar"]
