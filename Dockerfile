FROM adoptopenjdk:8u222-b10-jre-hotspot
VOLUME /tmp
COPY build/libs/BOOT-INF/lib /app/lib
COPY build/libs/META-INF /app/META-INF
COPY build/libs/BOOT-INF/classes /app
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "demo.DemoApplication"]
