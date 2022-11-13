FROM openjdk:8
EXPOSE 8089
COPY ./target/*.jar achat-1.0.jar
CMD ["java","-jar","achat-1.0.jar"]