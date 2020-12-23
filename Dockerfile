FROM openjdk:8
ENV AWS_ACCESS_KEY_ID=AKIA5S4TWFG2MJLEZXXZ \
    AWS_SECRET_KEY=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
ADD target/SpringAWSProject-1.0.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]
