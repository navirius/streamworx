package com.assignment.streamworx.api2.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
public class UserPostResponse {
    private int userid;
    private Integer id;
    private String title;
    private String body;
}
