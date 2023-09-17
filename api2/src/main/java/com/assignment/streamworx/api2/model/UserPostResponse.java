package com.assignment.streamworx.api2.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class UserPostResponse {
    private Integer id;
    private int userid;
    private String title;
    private String body;
}
