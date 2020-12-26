FROM openjdk:8
ENV AWS_ACCESS_KEY_ID=AKIAVM54LY3AJKKLRLWW \
    AWS_SECRET_KEY=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
ADD target/SpringAWSProject-1.0.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]