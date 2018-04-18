package com.example.oasystem_1_0.controller;

import com.example.oasystem_1_0.domain.po.Item;
import com.example.oasystem_1_0.domain.po.User;
import com.example.oasystem_1_0.exception.ItemException;
import com.example.oasystem_1_0.service.itemService;
import com.example.oasystem_1_0.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:11:27
 * @description：
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private userService userService;

    @Autowired
    private itemService itemService;

    @ResponseBody
    @RequestMapping("test")
    public Map hello( )
    {
        Map<String,String> map = new HashMap<>();
        map.put("test","success");
        return map;
    }

    @ResponseBody
    @RequestMapping("listUser")
    public List<User> listUser() throws Exception {
        return userService.listUser();
    }

    @ResponseBody
    @RequestMapping("listItem")
    public List<Item> listItem() throws ItemException {

        return itemService.listItem();
    }

}
