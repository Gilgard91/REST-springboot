# immagine base con JDK per la build
FROM eclipse-temurin:21-jdk-jammy as builder

# directory di lavoro
WORKDIR /app

# copia i file di configurazione Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# scarica le dipendenze (questo layer verrà cachato se pom.xml non cambia)
RUN ./mvnw dependency:go-offline -B

# copia il codice sorgente
COPY src src

# compila l'applicazione
RUN ./mvnw clean package -DskipTests

# seconda fase: runtime
FROM eclipse-temurin:21-jre-jammy

# crea un utente non-root per sicurezza
RUN addgroup --system spring && adduser --system --group spring
USER spring:spring

# copia il jar dall'immagine builder
COPY --from=builder /app/target/*.jar app.jar

# espone la porta 8080
EXPOSE 8080

# comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "/app.jar"]