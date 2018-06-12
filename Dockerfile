FROM openjdk:8

ADD springbootserver.jar /myapp/

WORKDIR /myapp/

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "springbootserver.jar"]

EXPOSE 8080
