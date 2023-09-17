package com.assignment.streamworx.api1.model;

import com.assignment.streamworx.api1.entity.AddressEntity;
import com.assignment.streamworx.api1.entity.CompanyEntity;
import lombok.Data;

import java.util.List;

@Data
public class Api1DataResponse {
    Integer id;
    String name;
    String username;
    String email;
    AddressEntity address;
    String phone;
    String website;
    CompanyEntity company;
    List<Api3DataResponse> todos;
    List<Api2UserPostDataResponse> posts;
}
