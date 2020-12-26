FROM openjdk:8
ENV AWS_ACCESS_KEY_ID=AKIAQHJLPQ37JEC5LMC5 \
    AWS_SECRET_KEY=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
ADD target/SpringAWSProject-1.0.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]