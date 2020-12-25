package com.aws.controller;

import com.aws.dynamoDBRepository.DynamoDbRepository;
import com.aws.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dynamoDB")
public class DynamoDBController {
    @Autowired
    private DynamoDbRepository dynamoDbRepository;

    @PostMapping
    public ResponseEntity<Student> insertIntoDynamoDB(@RequestBody Student student){
        dynamoDbRepository.insertIntoDynamoDB(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Student> getOneStudentDetails(@RequestParam String studentId, @RequestParam String lastName){
        Student student= dynamoDbRepository.getOneStudentDetails(studentId,lastName);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
}
