# Use Maven to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build

# set the working directory
WORKDIR /app

#copy the pom.xml
COPY pom.xml .
RUN mvn dependency:go-offline

#Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Use a lightweight JRE to run the app
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

COPY --from=build /app/target/smartmail-assist-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "smartmail-assist-0.0.1-SNAPSHOT.jar"]
