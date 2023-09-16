package com.assignment.streamworx.api1.entity;

import lombok.Data;

@Data
public class AddressEntity {
    String street;
    String suite;
    String city;
    String zipCode;
    GeoLocationEntity geo;
}
