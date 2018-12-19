package com.dzexercise;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Autor : dong
 * Time:2018/12/18
 */

class TestProperties {

    public static void main(String[] args) {

        // *.properties 称之为属性文件
        //Properties    称之为属性类
        // *.properties ->  Properties
        //读取文件：load -> Properties   InputStream/Reader
        //写入文件：store -> *.properties OutputStream/Writer
        Properties properties = new Properties();
        try {
            //1.通过FileInputStream
//            properties.load(new FileInputStream("E:\\worskpace\\java6_code\\javase1216\\src\\com\\bittech\\jcf\\hello.properties"));
//

            //2.通过ClassLoader的方式读取属性文件时，指定包路径
            InputStream inputStream = TestProperties.class.getClassLoader().getResourceAsStream("com/bittech/jcf/hello.properties");
            properties.load(inputStream);


            System.out.println(properties.get("c++"));
            System.out.println(properties.getProperty("c++"));
            System.out.println(properties.getProperty("php"));
            System.out.println(properties.getProperty("php", "PHP是最好的语言"));
            //1.getProperty(key)
            //2.getProperty(key,defaultValue)

            //1.put
            //2.setProperty (建议使用setProperty)
            properties.put("php", "PHP is best");
            properties.setProperty("Go", "Go is better");
            //5

            //存储
//            properties.store(new FileOutputStream(
//                    "E:\\worskpace\\java6_code\\javase1216\\src\\com\\bittech\\jcf\\hello-1.properties"
//            ), "写入数据");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

