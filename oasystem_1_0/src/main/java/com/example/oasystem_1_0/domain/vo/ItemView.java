package com.example.oasystem_1_0.domain.vo;

import com.example.oasystem_1_0.domain.po.Item;
import com.example.oasystem_1_0.domain.po.Process;
import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:18:10
 * @description：
 */
public class ItemView {
    private Item item;
    private List<Process> processes;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    @Override
    public String toString() {
        return "ItemView{" +
                "item=" + item +
                ", processes=" + processes +
                '}';
    }
}
