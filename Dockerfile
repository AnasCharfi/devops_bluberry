From openjdk:8
copy ./src/target/achat-1.0.jar achat-1.0.jar
CMD ["java","-jar","achat-1.0.jar"]
