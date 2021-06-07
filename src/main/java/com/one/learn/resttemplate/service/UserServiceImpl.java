package com.one.learn.resttemplate.service;

import com.one.learn.resttemplate.bean.User;
import com.one.learn.resttemplate.bean.UserJobDto;
import com.one.learn.resttemplate.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert() {
        User user = new User();
        user.setId(2);
        user.setName("lisi");
        user.setAge(12);
        userMapper.insert(user);
        System.out.println("插入成功");
    }

    @Override
    public String getUserJobDtoByUserId(Integer id) {
        UserJobDto userJobDtoByUserId = userMapper.getUserJobDtoByUserId(id);
        return Optional.ofNullable(userJobDtoByUserId).orElseGet(UserJobDto::new).toString();
    }
}
