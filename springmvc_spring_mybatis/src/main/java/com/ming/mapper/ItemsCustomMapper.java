package com.ming.mapper;

import com.ming.po.ItemsEx;
import com.ming.po.ItemsVO;

import java.util.List;

public interface ItemsCustomMapper {

    public List<ItemsEx> queryItemsByName(ItemsVO itemsVO) throws  Exception;
}
