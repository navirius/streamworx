package com.assignment.streamworx.api2.controller;

import com.assignment.streamworx.api2.model.UserDataModel;
import com.assignment.streamworx.api2.model.UserDataModelResponse;
import com.assignment.streamworx.api2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserService userService;

    @Operation(description = "API for delete user data")
    @PostMapping(value = "deleteUser", produces = {"application/xml", "text/xml"})
    public ResponseEntity deleteUserData(@RequestBody UserDataModel data){
        try{
            userService.deleteUserData(data);
            return ResponseEntity.ok().body(null);
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
        }
    }

    @Operation(description = "API for update user data")
    @PostMapping(value="updateUser", produces = {"application/xml", "text/xml"})
    public ResponseEntity updateUserData(@RequestBody UserDataModel data){
        try {
            userService.updateUserData(data);
            return ResponseEntity.ok().body(null);
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
        }
    }

    @Operation(description = "API for save user data")
    @PostMapping(value="saveUser", produces = {"application/xml", "text/xml"})
    @ResponseBody
    public UserDataModelResponse saveUserData(@RequestBody UserDataModel data){
        try {
            UserDataModel saved = userService.saveUserData(data);
            UserDataModelResponse response = new UserDataModelResponse();
            BeanUtils.copyProperties(saved, response);
            return response;
        }
        catch (Exception ex){
            log.error("ERROR>>>", ex);
            return null;
        }
    }

    @Operation(description = "API for get user data")
    @GetMapping(value = "getUser", produces = {"application/xml", "text/xml"})
    @ResponseBody
    public UserDataModelResponse getUserData(@RequestParam("userId") Integer userId){
        try {
            UserDataModel dbData = userService.getUserData(userId);
            UserDataModelResponse response = new UserDataModelResponse();
            BeanUtils.copyProperties(dbData, response);
            return response;
        }
        catch (Exception ex){
            log.error("ERROR>>>", ex);
            return null;
        }
    }
}
