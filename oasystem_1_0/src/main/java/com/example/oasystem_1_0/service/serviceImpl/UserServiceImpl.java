package com.example.oasystem_1_0.service.serviceImpl;

import com.example.oasystem_1_0.dao.UserMapper;
import com.example.oasystem_1_0.domain.po.ItemExample;
import com.example.oasystem_1_0.domain.po.User;
import com.example.oasystem_1_0.domain.po.UserExample;
import com.example.oasystem_1_0.exception.RegisterException;
import com.example.oasystem_1_0.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:12:04
 * @description：
 */
@Service
public class UserServiceImpl implements userService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() throws Exception
    {
        return userMapper.selectByExample(null);
    }

    @Override
    @Transactional
    public boolean addUser(User user) throws RegisterException {
        try {
            if (userMapper.insert(user) == 1)
                return true;
           else throw new RegisterException("注册失败");
        }
        catch(Exception e)
        {
            throw new RegisterException("注册失败");
        }
    }

    @Override
    public boolean getUserByUserAndPassword(User user) throws RegisterException {
        try{
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUsernameEqualTo(user.getUsername());
            criteria.andPasswordEqualTo(user.getPassword());
            List<User> users = userMapper.selectByExample(userExample);
            return users.size() == 1;
        }catch (Exception e)
        {
            throw new RegisterException("登录失败--dao");
        }



    }

}
