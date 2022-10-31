From openjdk:8
RUN mvn install
CMD [“echo”,“Stage 2 complete”]
copy ./target/achat-1.0.jar achat-1.0.jar
CMD ["java","-jar","achat-1.0.jar"]
