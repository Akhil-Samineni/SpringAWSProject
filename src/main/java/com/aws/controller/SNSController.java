package com.aws.controller;

import com.aws.sns.SnsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SNSController {
    @Autowired
    private SnsClient snsClient;

    @GetMapping("/createTopic")
    public String createTopicAndPublish(){
        snsClient.createTopicAndSubscribe();
        return "Able to create topic, subscription details sent";
    }

    @GetMapping("/sendSNS")
    public String sendSNS(){
        snsClient.publish();
        return "Able to publish message to email after successfully subscribed from java";
    }
}
