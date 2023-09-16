package com.assignment.streamworx.api1.controller;

import com.assignment.streamworx.api1.model.Api1DataResponse;
import com.assignment.streamworx.api1.service.Api1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api1/")
public class Api1Controller {

    @Autowired
    Api1Service api1Service;

    @GetMapping("alldata")
    public ResponseEntity getData(){
        List<Api1DataResponse> result = api1Service.getData();
        return ResponseEntity.ok().body(result);
    }
}
