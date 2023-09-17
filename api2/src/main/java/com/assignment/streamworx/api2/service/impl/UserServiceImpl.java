package com.assignment.streamworx.api2.service.impl;

import com.assignment.streamworx.api2.entity.UserEntity;
import com.assignment.streamworx.api2.model.UserDataModel;
import com.assignment.streamworx.api2.repository.UserRepository;
import com.assignment.streamworx.api2.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void deleteUserData(UserDataModel data) {
        if(data==null || data.getId()==null)
            return;
        Optional<UserEntity> dbData = userRepository.findById(data.getId());
        if(dbData.isPresent()){
            userRepository.delete(dbData.get());
        }
    }

    @Override
    public void updateUserData(UserDataModel data) {
        if(data==null || data.getId()==null)
            return;
        Optional<UserEntity> dbData = userRepository.findById(data.getId());
        if(dbData.isPresent()){
            UserEntity userEntity = dbData.get();
            BeanUtils.copyProperties(data, userEntity);
            userRepository.save(userEntity);
        }
    }

    @Override
    public UserDataModel saveUserData(UserDataModel data) {
        if(data==null || data.getId()==null)
            return null;

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(data, userEntity);
        UserEntity dbSaved = userRepository.save(userEntity);

        UserDataModel result = new UserDataModel();
        BeanUtils.copyProperties(dbSaved, result);
        return result;
    }

    @Override
    public UserDataModel getUserData(Integer userId) {
        Optional<UserEntity> dbData = userRepository.findById(userId);
        if(dbData.isPresent()){
            UserDataModel result = new UserDataModel();
            BeanUtils.copyProperties(dbData.get(), result);
            return result;
        }

        return null;
    }
}
