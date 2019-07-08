package com.ming.mapper;


import com.ming.po.ItemsCustom;
import com.ming.po.ItemsVO;

import java.util.List;

public interface ItemsMapperCustom
{
    public List<ItemsCustom> queryItemsByName(ItemsVO itemsVO) throws Exception;


    //依据IDs删除
    public void deleteItems(Integer [] ids) throws Exception;
    //public ItemsCustom queryItemsById(int id) throws Exception;
}