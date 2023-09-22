package com.assignment.streamworx.api1.controller;

import com.assignment.streamworx.api1.entity.UserEntity;
import com.assignment.streamworx.api1.feign.Api3FeignService;
import com.assignment.streamworx.api1.model.Api1DataResponse;
import com.assignment.streamworx.api1.model.Api3DataResponse;
import com.assignment.streamworx.api1.repository.UserRepository;
import com.assignment.streamworx.api1.service.Api1Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1/")
public class Api1Controller {

    @Autowired
    Api1Service api1Service;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Api3FeignService api3FeignService;
    @GetMapping("alldata")
    public ResponseEntity getData(){
        List<Api1DataResponse> result = api1Service.getData();
        return ResponseEntity.ok().body(result);
    }

    @Operation(description = "getall api 3 data")
    @GetMapping("api3")
    public ResponseEntity getApi3(){
        List<Api3DataResponse> result = api3FeignService.getAllApi3Data();
        return ResponseEntity.ok().body(result);
    }
    
    @Operation(description = "add json data API to redis")
    @PostMapping("addJsonRedisData")
    public ResponseEntity addJsonData(@RequestBody List<UserEntity> dataUser){
        
    }
}
