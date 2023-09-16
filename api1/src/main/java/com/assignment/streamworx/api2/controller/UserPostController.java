package com.assignment.streamworx.api2.controller;

import com.assignment.streamworx.api2.model.UserPostRequest;
import com.assignment.streamworx.api2.model.UserPostResponse;
import com.assignment.streamworx.api2.service.UserPostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/userpost/")
public class UserPostController {

    @Autowired
    UserPostService userPostService;

    @Operation(description = "API to insert/save new user post data")
    @PostMapping("save")
    public UserPostResponse saveUserPost(@RequestBody UserPostRequest request){
        try {
            UserPostResponse dataSaved = userPostService.saveUserPost(request);
            return dataSaved;
        }
        catch (Exception ex){
            log.error("ERROR", ex);
            return null;
        }
    }

    @Operation(description = "API to delete user post data")
    @PostMapping("delete")
    public ResponseEntity deleteUserPost(@RequestBody UserPostRequest request){
        try {
            userPostService.deleteUserPost(request);
            return ResponseEntity.ok().body(null);
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
        }
    }

    @Operation(description = "API to update user post data")
    @PostMapping("update")
    public ResponseEntity updateUserPost(@RequestBody UserPostRequest request){
        try {
            userPostService.updateUserPost(request);
            return ResponseEntity.ok().body(null);
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
        }
    }

    @Operation(description = "API for get all user post data")
    @GetMapping(value = "getpost", produces = {"application/xml", "text/xml"})
    @ResponseBody
    public UserPostResponse getUserPostData(@RequestParam("postId")Integer postId){
        try {
            UserPostResponse dataResult = userPostService.getUserPost(postId);
            return dataResult;
        }
        catch (Exception ex){
            log.error("ERROR>>>", ex);
            return null;
        }
    }

    @Operation(description = "API for get user post data")
    @GetMapping(value = "allpostuser", produces = {"application/xml", "text/xml"})
    @ResponseBody
    public List<UserPostResponse> getAllUserPostData(@RequestParam("userId")Integer userId){
        try {
            List<UserPostResponse> dataResult = userPostService.getAllUserPost(userId);
            return dataResult;
        }
        catch (Exception ex){
            log.error("ERROR>>>", ex);
            return null;
        }
    }
}
