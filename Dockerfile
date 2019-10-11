FROM adoptopenjdk:8u222-b10-jre-hotspot
VOLUME /tmp
COPY build/libs/makeit19-dockerizing-spring-boot-*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
