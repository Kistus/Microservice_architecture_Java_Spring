FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV LAB4_GATEWAY_URL=lab4-gateway:8080
ENV LAB4_MEMBERS_URL=http://lab1aui-man:8080
ENV LAB4_PROJECT_URL=http://lab1aui-job:8080

EXPOSE 8080

COPY target/lab4.gateway-${VERSION}.jar /opt/lab4.gateway/lab4.gateway.jar

CMD ["java", "-jar", "/opt/lab4.gateway/lab4.gateway.jar"]