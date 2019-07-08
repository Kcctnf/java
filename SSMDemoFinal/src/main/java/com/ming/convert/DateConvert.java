package com.ming.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert implements Converter<String, Date> {

    String strFormat = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date convert(String source) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
            date = sdf.parse(source);
            return date;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
