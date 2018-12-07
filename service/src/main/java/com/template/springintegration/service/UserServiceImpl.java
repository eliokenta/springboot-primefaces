package com.template.springintegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.springintegration.entity.UserInfo;
import com.template.springintegration.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfo createUser(UserInfo user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserInfo> listUsers() {
        List<UserInfo> userList = new ArrayList<UserInfo>();
        userRepository.findAll().forEach(userInfo -> userList.add(userInfo));

        return userList;
    }
}
