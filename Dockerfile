# 1. Fase de Construcción (Build Phase)
# Usar una imagen base de Maven que incluye Java 17.
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo de configuración de Maven (pom.xml)
COPY pom.xml .

# Copiar el código fuente
COPY src ./src

# Construir la aplicación Spring Boot.
RUN mvn clean package -DskipTests

# 2. Fase de Ejecución (Run Phase)
# Usar una imagen base solo de Java 17 (más ligera) para ejecutar el JAR.
FROM eclipse-temurin:17-jre-alpine

# Exponer el puerto 8080 (el puerto por defecto de Spring Boot)
EXPOSE 8080

# Copiar el archivo JAR generado desde la fase de construcción a la imagen final.
COPY --from=build /app/target/*.jar app.jar

# Comando para ejecutar la aplicación Java al iniciar el servicio.
CMD ["java", "-jar", "app.jar"]