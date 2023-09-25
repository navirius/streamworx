package com.assignment.streamworx.api1.job;

import com.assignment.streamworx.api1.entity.UserEntity;
import com.assignment.streamworx.api1.feign.UsersApiFeignService;
import com.assignment.streamworx.api1.model.RedisUserModel;
import com.assignment.streamworx.api1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class InsertRedisDataJob {

    @Autowired
    UsersApiFeignService usersApiFeignService;
    @Autowired
    UserRepository userRepository;

    @Scheduled(initialDelay = 1, fixedDelay = 999999999, timeUnit = TimeUnit.SECONDS)
    public void inserData(){
        List<RedisUserModel> listUser = usersApiFeignService.getAllData();
        for(RedisUserModel userModel:listUser){
            //userRepository.findById()
            Optional<UserEntity> userEntity = userRepository.findById(userModel.getId());
            if(userEntity.isPresent()) {
                UserEntity user = userEntity.get();
                BeanUtils.copyProperties(userModel, user);
                userRepository.save(user);
            }
            else{
                UserEntity user = new UserEntity();
                BeanUtils.copyProperties(userModel, user);
                userRepository.save(user);
            }

        }
    }
}
