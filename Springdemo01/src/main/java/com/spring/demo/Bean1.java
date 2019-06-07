package com.spring.demo;

import org.springframework.context.annotation.Bean;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * IOC
 * DI:依赖注入 setter方法
 */
public class Bean1 {

    private int intValue22;

    private String strValue;

    private String [] strArray;

    private List listValue;

    private Map mapValue;

    private Set setValue;


    private Date dateValue;

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public Set getSetValue() {
        return setValue;
    }

    public void setSetValue(Set setValue) {
        this.setValue = setValue;
    }

    public Map getMapValue() {
        return mapValue;
    }

    public void setMapValue(Map mapValue) {
        this.mapValue = mapValue;
    }

    public List getListValue() {
        return listValue;
    }

    public void setListValue(List listValue) {
        this.listValue = listValue;
    }

    public String[] getStrArray() {
        return strArray;
    }

    public void setStrArray(String[] strArray) {
        this.strArray = strArray;
    }

    public int getIntValue22() {
        return intValue22;
    }

    public void setIntValue22(int intValue22) {
        this.intValue22 = intValue22;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public Bean1(){

    }

    public int getIntValue() {
        return intValue22;
    }

    //DI 依赖注入
    public void setIntValue(int intValue) {
        this.intValue22 = intValue;
    }
}
