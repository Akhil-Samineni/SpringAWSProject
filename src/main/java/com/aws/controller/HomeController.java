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

    @GetMapping("/uploadFile1")
    public String uploadFile() {
        s3JavaSDK.uploadFile("akhils3sdkbukcet12345","sometext");
        return "File uploaded successfully";
    }

    @GetMapping("/uploadFile2")
    public String uploadFile2() {
        s3JavaSDK.uploadFile("akhils3sdkbukcet12345","sometext2");
        return "File uploaded successfully";
    }

    @GetMapping("/createBucketTransitEncrypt")
    public String createBucketTransitEncrypt() throws Exception {
        s3JavaSDK.createAndTransitEncryptSimpleBucket();
        return "createBucketTransitEncrypt created successfully";
    }
}
