package com.ming.service;

import com.ming.mapper.ItemsMapper;
import com.ming.mapper.ItemsMapperCustom;
import com.ming.po.Items;
import com.ming.po.ItemsCustom;
import com.ming.po.ItemsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * call by mapper layer
 */

public class ItemsServiceImpl implements ItemsService
{
    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;


    @Override
    public List<ItemsCustom> queryItemsByName(ItemsVO itemsVO) throws Exception
    {
        //通过ItemsCusotm查询数据库
        List<ItemsCustom> itemsCustomList = itemsMapperCustom.queryItemsByName(itemsVO);
        return itemsCustomList;
    }

    /**
     * 根据id查找items的信息
     * 说明：为什么不用我的自己定义的queryItemsById
     * 因为在我们的业务中Items == ItemsCustom
     * @param id
     * @return
     * @throws Exception
     */

    @Override
    public ItemsCustom findItemsById(int id) throws Exception
    {
        Items items =  itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items,itemsCustom);
        return itemsCustom;
    }

    /**
     * 根据id修改信息
     * @param id
     * @param itemsCustom
     * @throws Exception
     */

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception
    {
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);

    }

    @Override
    public void moveItemsByIdentifies(Integer[] ids) throws Exception {
        itemsMapperCustom.deleteItems(ids);
    }

    //根据ID进行删除
    @Override
    public void moveItemsByIdentify(Integer id) throws Exception {
        itemsMapper.deleteByPrimaryKey(id);
    }

    //添加(Service)
    @Override
    public void addItems(ItemsCustom itemsCustom) throws Exception {
        itemsMapper.insert(itemsCustom);
    }
}
