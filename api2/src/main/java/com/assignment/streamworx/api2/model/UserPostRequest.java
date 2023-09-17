package com.assignment.streamworx.api2.model;

import lombok.Data;

@Data
public class UserPostRequest {
    private Integer id;
    private int userid;
    private String title;
    private String body;

}
