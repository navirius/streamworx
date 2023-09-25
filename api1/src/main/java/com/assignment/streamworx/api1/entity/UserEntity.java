package com.assignment.streamworx.api1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@RedisHash("User")
public class UserEntity implements Serializable {
    @Id @Indexed
    Integer id;
    String name;
    String username;
    String email;
    AddressEntity address;
    String phone;
    String website;
    CompanyEntity company;
}
