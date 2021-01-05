package com.aws.controller;

import com.aws.sns.SnsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/sns")
public class SNSController {
    @Autowired
    private SnsClient snsClient;
    @GetMapping("/createTopic")
    public String createTopicAndPublish(){
        snsClient.createTopicAndSubscribe();
        return "Able to create topic, subscribe to it and publish to that topic from Java";
    }
}
