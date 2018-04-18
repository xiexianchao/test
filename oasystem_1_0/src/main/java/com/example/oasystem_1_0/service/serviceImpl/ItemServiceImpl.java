package com.example.oasystem_1_0.service.serviceImpl;

import com.example.oasystem_1_0.dao.ItemMapper;
import com.example.oasystem_1_0.dao.ProcessMapper;
import com.example.oasystem_1_0.domain.po.Item;
import com.example.oasystem_1_0.domain.po.ItemExample;
import com.example.oasystem_1_0.exception.ItemException;
import com.example.oasystem_1_0.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.oasystem_1_0.domain.po.Process;

import java.util.Date;
import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:14:34
 * @description：
 */

@Service
public class ItemServiceImpl implements itemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ProcessMapper processMapper;


    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public boolean addItem(Item item, List<Process> processes) throws ItemException {
        try {
            item.setGmtCreate(new Date());
            item.setGmtModified(new Date());
            if (itemMapper.insertItem(item) == 1 )
            {
                for (Process process:processes) {
                    process.setItemId(item.getId());
                    process.setGmtCreate(new Date());
                    process.setGmtModified(new Date());
                   if(1 != processMapper.insert(process))
                       return false;
                }
                 return true;
            }
            else
                throw new ItemException("添加信息失败");
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new ItemException("添加信息失败");
        }
    }

    @Override
    public List<Item> listItemByUserId(long userId) throws ItemException {
        ItemExample example = new ItemExample();
        ItemExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return itemMapper.selectByExample(example);
    }

    @Override
    public List<Item> listItem() throws ItemException {
        return itemMapper.selectByExample(null);
    }
}
