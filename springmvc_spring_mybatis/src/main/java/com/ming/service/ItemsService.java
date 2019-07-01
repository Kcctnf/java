package com.ming.service;

import com.ming.po.ItemsEx;
import com.ming.po.ItemsVO;

import java.util.List;

public interface ItemsService {

    //依据名称查询商品列表
    public List<ItemsEx> chaXunItemsListService(ItemsVO itemsVO) throws Exception;
}
