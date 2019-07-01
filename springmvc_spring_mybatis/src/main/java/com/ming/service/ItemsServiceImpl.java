package com.ming.service;

import com.ming.mapper.ItemsCustomMapper;
import com.ming.po.ItemsEx;
import com.ming.po.ItemsVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * service层 （该层需要调用mapper接口）
 */
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsCustomMapper itemsCustomMapper;

    @Override
    public List<ItemsEx> chaXunItemsListService(ItemsVO itemsVO) throws Exception {
        return null;
    }
}
