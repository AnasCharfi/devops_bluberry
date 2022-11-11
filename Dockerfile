From openjdk:8
EXPOSE 8089
copy ./target/*.jar achat-1.0.jar
CMD ["java","-jar","achat-1.0.jar"]