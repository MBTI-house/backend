FROM amazoncorretto:11

WORKDIR /project
COPY . /project
RUN chmod 777 gradlew && ./gradlew bootJar



