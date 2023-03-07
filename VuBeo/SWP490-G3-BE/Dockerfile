FROM openjdk:17-jdk-alpine
ADD target/*.jar dat-san-rest-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx896m", "-jar", "dat-san-rest-api.jar"]
RUN apk add tzdata
RUN cd /usr/share/zoneinfo
RUN cp /usr/share/zoneinfo/Asia/Saigon /etc/localtime
