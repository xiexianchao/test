package com.example.oasystem_1_0.service;

import com.example.oasystem_1_0.domain.po.Item;
import com.example.oasystem_1_0.exception.ItemException;
import com.example.oasystem_1_0.domain.po.Process;

import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:14:33
 * @description：
 */

public interface itemService {
    boolean addItem(Item item, List<Process> processes) throws ItemException;
    List<Item> listItemByUserId( long userId) throws ItemException;

    List<Item> listItem() throws ItemException;
}
