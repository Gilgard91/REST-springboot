# Usa un'immagine base con JDK per la build
FROM eclipse-temurin:21-jdk-jammy as builder

# Imposta la directory di lavoro
WORKDIR /app

# Copia i file di configurazione Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Scarica le dipendenze (questo layer verrà cachato se pom.xml non cambia)
RUN ./mvnw dependency:go-offline -B

# Copia il codice sorgente
COPY src src

# Compila l'applicazione
RUN ./mvnw clean package -DskipTests

# Seconda fase: runtime
FROM eclipse-temurin:21-jre-jammy

# Crea un utente non-root per sicurezza
RUN addgroup --system spring && adduser --system --group spring
USER spring:spring

# Copia il jar dall'immagine builder
COPY --from=builder /app/target/*.jar app.jar

# Espone la porta 8080 (default per Spring Boot)
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "/app.jar"]