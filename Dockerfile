FROM openjdk:14-alpine
COPY build/libs/clean_arch-*-all.jar clean_arch.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "clean_arch.jar"]