FROM openjdk:8
RUN apt-get install curl
RUN curl -u admin:Root2205 -o achat.jar "http://192.168.33.10:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8082
