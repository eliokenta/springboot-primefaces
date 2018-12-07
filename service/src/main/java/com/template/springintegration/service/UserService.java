package com.template.springintegration.service;

import com.template.springintegration.entity.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo createUser(UserInfo user);

    List<UserInfo> listUsers();
}
