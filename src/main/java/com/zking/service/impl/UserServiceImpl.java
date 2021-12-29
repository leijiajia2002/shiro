package com.zking.service.impl;

import com.zking.mapper.UserMapper;
import com.zking.model.User;
import com.zking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public Set<String> getRole(String username) {
        return userMapper.getRole(username);
    }

    @Override
    public Set<String> getPermssion(String username) {
        return userMapper.getPermssion(username);
    }
}
