FROM openjdk:8
ENV AWS_ACCESS_KEY_ID=AKIAQVBGJMYARKOE2XEX \
    AWS_SECRET_KEY=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
ADD target/SpringAWSProject-1.0.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]