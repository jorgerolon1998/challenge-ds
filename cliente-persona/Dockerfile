# Usa la imagen base oficial de OpenJDK
FROM openjdk:11-jre-slim

# Añade un volumen para los archivos temporales
VOLUME /tmp

# Argumento para el archivo JAR
ARG JAR_FILE=target/*.jar

# Copia el JAR construido al contenedor Docker
COPY ${JAR_FILE} app.jar

# Expone el puerto que será usado por el microservicio
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
