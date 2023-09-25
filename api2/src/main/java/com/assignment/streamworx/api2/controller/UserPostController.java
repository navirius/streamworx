package com.assignment.streamworx.api2.controller;

import com.assignment.streamworx.api2.model.ListUserPost;
import com.assignment.streamworx.api2.model.UserPostRequest;
import com.assignment.streamworx.api2.model.UserPostResponse;
import com.assignment.streamworx.api2.service.UserPostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ListUserPost getUserPostData(@RequestParam("postId")Integer postId){
        try {
            UserPostResponse dataResult = userPostService.getUserPost(postId);
            ListUserPost result = new ListUserPost();
            result.setRow(new ArrayList<>(){
                {
                    add(dataResult);
                }
            });
            return result;
        }
        catch (Exception ex){
            log.error("ERROR>>>", ex);
            return null;
        }
    }

    @Operation(description = "API for get user post data")
    @GetMapping(value = "allpostuser", produces = {"application/xml", "text/xml"})
    @ResponseBody
    public ListUserPost getAllUserPostData(@RequestParam("userId")Integer userId){
        try {
            List<UserPostResponse> dataResult = userPostService.getAllUserPost(userId);
            ListUserPost result = new ListUserPost();
            result.setRow(dataResult);
            return result;
        }
        catch (Exception ex){
            log.error("ERROR>>>", ex);
            return null;
        }
    }


    @Operation(description = "API for get all post data")
    @GetMapping(value = "allpost", produces = {"application/xml", "text/xml", MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ListUserPost getAllPostData(){
        try {
            List<UserPostResponse> dataResult = userPostService.getAllPost();
            ListUserPost result = new ListUserPost();
            result.setRow(dataResult);
            return result;
        }
        catch (Exception ex){
            log.error("ERROR>>>", ex);
            return null;
        }
    }
}
