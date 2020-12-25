FROM openjdk:8
ENV AWS_ACCESS_KEY_ID=AKIAYW3I3N5DWJNAH7EV \
    AWS_SECRET_KEY=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
ADD target/SpringAWSProject-1.0.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]