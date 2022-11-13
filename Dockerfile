FROM openjdk:12-alpine
WORKDIR opt/thouraya
COPY ./target/achat-1.0.jar achat-1.0.jar
CMD ["java","-jar","achat-1.0.jar"]