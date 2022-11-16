From openjdk:8
EXPOSE 8089
copy ./target/*.jar achat-1.0.3-SNAPSHOT.jar
CMD ["java","-jar","achat-1.0.3-SNAPSHOT.jar"]