package com.example.oasystem_1_0.controller;

import com.example.oasystem_1_0.domain.po.Item;

import com.example.oasystem_1_0.domain.vo.ItemView;
import com.example.oasystem_1_0.exception.ItemException;
import com.example.oasystem_1_0.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.oasystem_1_0.domain.po.Process;


import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:14:33
 * @description：
 */
@Controller
@RequestMapping(value="/item")
public class ItemController {

    @Autowired
    private itemService itemService;


    @ResponseBody
    @RequestMapping(value="/addItem",method= RequestMethod.POST)
    public Map<String,String> addItem(@RequestBody ItemView itemView) throws ItemException {

        System.out.println(itemView.toString());
        Item item = itemView.getItem();
        List<Process> processes = itemView.getProcesses();

        Map<String,String> map = new HashMap<>();
       if(itemService.addItem(item,processes))
            map.put("addItem","success");
        else
            map.put("addItem","failed");
        return map;
    }
}
