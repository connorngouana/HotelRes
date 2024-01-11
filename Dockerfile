FROM openjdk:17

WORKDIR /app

COPY target/HotelReservation-0.0.1-SNAPSHOT.jar /app

EXPOSE 8084

CMD ["java", "-jar" , "HotelReservation-0.0.1-SNAPSHOT.jar" , "--spring.profiles.active=docker"]