FROM openjdk:8-jdk-alpine
COPY app.jar /app/app.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENV TIME_ZONE=Asia/Shanghai
ENTRYPOINT exec java $JAVA_OPTS -jar /app/app.jar --spring.profiles.active=dev #springboot的环境配置
