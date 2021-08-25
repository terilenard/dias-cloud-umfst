# ----- 1. Jar Building Stage -----
FROM maven:3.6-jdk-11 AS build

# Copy the contents of the src directory
ADD src /usr/src/maven.consumer.hono/src/

# Copy the project file
COPY pom.xml /usr/src/maven.consumer.hono

# Copy the Dockerfile
COPY Dockerfile /usr/src/maven.consumer.hono


# Run maven
RUN mvn -f /usr/src/maven.consumer.hono/pom.xml package -DskipTests

# ----- 2. Image Building Stage -----
FROM openjdk:11

# Set the work directory
WORKDIR /jardir

# Copy the built jar file from the previous stage to the current directory 
COPY --from=build /usr/src/maven.consumer.hono/target/maven.consumer.hono-0.0.1-SNAPSHOT.jar /jardir

# Set the entry point
ENTRYPOINT ["java", "-jar", "maven.consumer.hono-0.0.1-SNAPSHOT.jar"]

# ----- Docker Command Examples -----

# docker build -t hono-log-consumer .
# docker run -p 8081:8081 -t hono-influxdb-connector --hono.client.tlsEnabled=true --hono.client.username=messaging@t6906174622ff488ba9b97d1fefc53459 --hono.client.password=1234 --tenant.id=t6906174622ff488ba9b97d1fefc53459 --device.id=1234 --export.ip=influxdb:8086
# docker login --username={$USERNAME} --password={$PASSWORD}
# docker tag hono-log-consumer ubuntu/hono-log-consumer
# docker push ubuntu/hono-log-consumer
# docker image rm image_id --force
# docker pull ubuntu/hono-log-consumer