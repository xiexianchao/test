package com.example.oasystem_1_0.service;

import com.example.oasystem_1_0.domain.po.User;
import com.example.oasystem_1_0.exception.RegisterException;

import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:12:03
 * @description：
 */
public interface userService {

    List<User> listUser() throws Exception;
    boolean addUser(User user) throws RegisterException;
    boolean getUserByUserAndPassword(User user) throws RegisterException;

}
