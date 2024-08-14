# Stage 1: Build the Angular application
FROM node:17.0.1 AS node-build
WORKDIR /app/src/main/UI
COPY /src/main/UI . 
RUN npm install
RUN npm install -g @angular/cli@14.1.3
# RUN npm run build --prod

# Stage 2: Build the Spring Boot application
FROM maven:3.8.6-openjdk-18 AS maven-build
WORKDIR /app
COPY . /app

# Copy Angular build output from the first stage to the Spring Boot resources directory
# COPY --from=node-build /app/src/main/UI/dist/your-angular-app-name /app/src/main/resources/static

RUN mvn clean package -DskipTests

# Stage 3: Create the final image
FROM openjdk:18-jdk-slim
COPY --from=maven-build /app/target/D387_sample_code-0.0.2-SNAPSHOT.jar /usr/local/lib/D387_sample_code-0.0.2-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/D387_sample_code-0.0.2-SNAPSHOT.jar"]
