package com.assignment.streamworx.api1.service;

import com.assignment.streamworx.api1.model.Api1DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Api1Service {
    List<Api1DataResponse> getData();
}
