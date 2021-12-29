package com.zking.service;

import com.zking.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface IUserService {
    User selectByName(String username);


    /**
     * 根据用户名获取到用户的角色信息
     * @param username
     * @return
     */
    Set<String> getRole(String username);

    /**
     * 根据用户名获取用户的权限信息
     * @param username
     * @return
     */
    Set<String> getPermssion(String username);

}
