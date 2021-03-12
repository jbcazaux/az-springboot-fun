FROM adoptopenjdk:11-jre-hotspot as builder
WORKDIR build
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
COPY --from=builder build/dependencies/ ./
RUN true
COPY --from=builder build/spring-boot-loader ./
RUN true
COPY --from=builder build/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]