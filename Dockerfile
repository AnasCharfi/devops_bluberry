FROM openjdk:8
EXPOSE 8082
COPY target/achat.jar achat.jar
CMD ["java","-jar","/achat.jar"]