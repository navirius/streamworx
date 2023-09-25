package com.assignment.streamworx.api1.model;

import com.assignment.streamworx.api1.entity.AddressEntity;
import com.assignment.streamworx.api1.entity.CompanyEntity;
import lombok.Data;

@Data
public class RedisUserModel {
    Integer id;
    String name;
    String username;
    String email;
    AddressEntity address;
    String phone;
    String website;
    CompanyEntity company;
}
