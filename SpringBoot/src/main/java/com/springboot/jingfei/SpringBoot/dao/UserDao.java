package com.springboot.jingfei.SpringBoot.dao;

import com.springboot.jingfei.SpringBoot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> getUserList();
}
