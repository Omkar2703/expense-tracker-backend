# Step 1: Build the app using Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY expense-tracker/pom.xml .
COPY expense-tracker/src ./src
RUN mvn clean package -DskipTests

# Step 2: Run the app using Java
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]