package com.example.oasystem_1_0.controller;

import com.example.oasystem_1_0.domain.po.User;
import com.example.oasystem_1_0.exception.RegisterException;
import com.example.oasystem_1_0.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:14:33
 * @description：
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private userService userService;

    @ResponseBody
    @RequestMapping(value= "/register", method = {RequestMethod.POST})
    public Map register(@RequestBody User user) throws RegisterException {
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        user.setState((byte) 0);

        Map<String,String> message = new HashMap<>();
        if(userService.addUser(user))
        {
            message.put("register","success");
            message.put("state",user.getState()+"");
        }else{
            message.put("register","failed");
        }
        return message;
    }

}
