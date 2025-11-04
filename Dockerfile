# 1. Fase de Construcción (Build Phase)
# Usar una imagen base de Maven para construir el proyecto.
FROM maven:3.8.6-openjdk-17-slim AS build

# Copiar el pom.xml y el código fuente.
COPY pom.xml .
COPY src ./src

# Construir la aplicación Spring Boot (esto genera el archivo .jar)
RUN mvn clean package -DskipTests

# 2. Fase de Ejecución (Run Phase)
# Usar una imagen base más ligera (solo Java) para ejecutar el JAR.
FROM openjdk:17-jdk-slim

# Exponer el puerto 8080 (el puerto por defecto de Spring Boot)
EXPOSE 8080

# Copiar el archivo JAR generado desde la fase de construcción a la imagen final.
COPY --from=build target/*.jar app.jar

# Comando para ejecutar la aplicación Java al iniciar el servicio.
CMD ["java", "-jar", "app.jar"]