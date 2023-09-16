package com.assignment.streamworx.api2.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class UserDataModelResponse {
    Integer id;
    String userName;
}
