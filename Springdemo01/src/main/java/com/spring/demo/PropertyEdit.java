package com.spring.demo;

/**
 * Author : dong
 * Time:2019/6/7
 */

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义属性编辑器
 */
public class PropertyEdit extends PropertyEditorSupport {
    private String format = "xxxxxxxxx";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("text = " + text);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        try {
            Date date = simpleDateFormat.parse(text);
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
