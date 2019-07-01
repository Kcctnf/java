package com.ming.po;

/**
 * 包装类
 * VO: Value Object (三层都可以访问)
 */
public class ItemsVO {

    private Items items;//原类
    private ItemsEx itemsEx;//扩展类

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsEx getItemsEx() {
        return itemsEx;
    }

    public void setItemsEx(ItemsEx itemsEx) {
        this.itemsEx = itemsEx;
    }
}
