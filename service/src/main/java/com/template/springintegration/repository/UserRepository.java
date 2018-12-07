package com.template.springintegration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.template.springintegration.entity.UserInfo;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, String> {

}
