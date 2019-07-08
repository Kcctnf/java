package com.ming.service;

import com.ming.po.Items;
import com.ming.po.ItemsCustom;
import com.ming.po.ItemsVO;

import java.util.List;

public interface ItemsService
{
    //查询数据库Items表
    public List<ItemsCustom> queryItemsByName(ItemsVO itemsVO) throws Exception;

    public ItemsCustom findItemsById(int id) throws Exception;

    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;


    //根据IDs删除
    public void moveItemsByIdentifies(Integer [] ids) throws Exception;

    //根据ID删除
    public void moveItemsByIdentify(Integer id) throws Exception;

    //添加
    public void addItems(ItemsCustom itemsCustom) throws Exception;


}
