package com.aws.sns;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.aws.util.Credentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SnsClient {
    private static AmazonSNSClient amazonSNSClient;
    private static final Logger logger= LogManager.getLogger(SnsClient.class);
    private static final String EMAIL_SUBJECT="Test SNS Notification from Java";
    private static final String EMAIL_MESSAGE="Able to create topic, subscribe to it and publish to that topic from Java";
    @Autowired
    private Credentials credentials;
    public void createTopicAndSubscribe(){
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(credentials.getAwsAccessKey(),credentials.getAwsSecretKey());
        amazonSNSClient = (AmazonSNSClient) AmazonSNSClientBuilder.standard().
                withRegion(credentials.getAwsRegion()).
                withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
        final CreateTopicRequest createTopicRequest= new CreateTopicRequest("MyEmailTopicFromJava");
        final CreateTopicResult createTopicResult= amazonSNSClient.createTopic(createTopicRequest);

        String TOPIC_ARN = createTopicResult.getTopicArn();
        logger.debug("TOPIC_ARN is {}" , TOPIC_ARN );
        logger.debug("Create topic request: "+ amazonSNSClient.getCachedResponseMetadata(createTopicRequest));
        final SubscribeResult subscribeResult =amazonSNSClient.subscribe(TOPIC_ARN,"email","akhilsamineni47@gmail.com");

        amazonSNSClient.publish(TOPIC_ARN,EMAIL_MESSAGE,EMAIL_SUBJECT);

    }

}
