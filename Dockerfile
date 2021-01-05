FROM openjdk:8
ENV AWS_ACCESS_KEY_ID=AKIAXN6SGZPUXG6ZSC6A \
    AWS_SECRET_KEY=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
ADD target/SpringAWSProject-1.0.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]