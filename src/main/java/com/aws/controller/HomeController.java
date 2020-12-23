package com.aws.controller;

import com.aws.impl.S3JavaSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    public S3JavaSDK s3JavaSDK;

    @GetMapping("/createBucket")
    public String createBucket() {
        s3JavaSDK.createAndPopulateSimpleBucket();
        return "Bucket created successfully";
    }

    @GetMapping("/createBucketTransitEncrypt")
    public String createBucketTransitEncrypt() throws Exception {
        s3JavaSDK.createAndTransitEncryptSimpleBucket();
        return "createBucketTransitEncrypt created successfully";
    }
}
