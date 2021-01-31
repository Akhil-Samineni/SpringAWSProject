package com.aws.controller;

import com.aws.impl.S3JavaSDK;
import com.aws.sns.SnsClient;
import com.aws.util.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    public S3JavaSDK s3JavaSDK;

    @Autowired
    public Credentials credentials;

    @GetMapping("/createBucket")
    public String createBucket() {
        s3JavaSDK.createAndPopulateSimpleBucket();
        return "Bucket created successfully";
    }

    @GetMapping("/uploadFile1")
    public String uploadFile() {
        s3JavaSDK.uploadFile(credentials.getBucketName(),"sometext.txt");
        return "File uploaded successfully";
    }

    @GetMapping("/uploadFile2")
    public String uploadFile2() {
        s3JavaSDK.uploadFile(credentials.getBucketName(),"sometext2.txt");
        return "File uploaded successfully";
    }

    @GetMapping("/createBucketTransitEncrypt")
    public String createBucketTransitEncrypt() throws Exception {
        s3JavaSDK.createAndTransitEncryptSimpleBucket();
        return "createBucketTransitEncrypt created successfully";
    }
}
