package com.spring.demo;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    private ApplicationContext applicationContext = null;

    @Before
    public void initialFun(){
        //初始化Spring容器
        //applicationContext = new ClassPathXmlApplicationContext("applicationContext-*.xml");
//        applicationContext =
////                new ClassPathXmlApplicationContext(new String[]{"applicationContext-prop.xml","applicationContext-beans.xml"});

        //通配符applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext-*.xml");
        //String数组
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext1.xml"});
    }

    @Test
    public void testBeanFunc(){
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        System.out.println("intValue = " + bean1.getIntValue());
        System.out.println("strValue = " + bean1.getStrValue());
        System.out.println("strArrayValue = " + bean1.getStrArray());
        for(int i = 0; i < bean1.getStrArray().length; i++){
            System.out.println("strArrayValue["+i+"] = "  + bean1.getStrArray()[i]);
        }

        System.out.println("strListValue = " + bean1.getListValue());
        System.out.println("mapValue key1 = " + bean1.getMapValue().get("key1"));
        System.out.println("mapValue key2 = " + bean1.getMapValue().get("key2"));
        System.out.println("mapValue key3 = " + bean1.getMapValue().get("key3"));
        System.out.println("setValue = " + bean1.getSetValue());


        System.out.println("dateValue = " + bean1.getDateValue());

    }

    @Test
    public void testBeanFunc1(){
        Bean2 bean2 = (Bean2)applicationContext.getBean("bean2");
        System.out.println("bean2.bean3.id = " + bean2.getBean3().getId());
        System.out.println("bean2.bean3.username = " + bean2.getBean3().getUsername());
        System.out.println("bean2.bean3.password = " + bean2.getBean3().getPassword());
        System.out.println("=================================================");
        System.out.println("bean2.bean4.id = " + bean2.getBean4().getGender());
        System.out.println("bean2.bean4.username = "+ bean2.getBean4().getHobity());
        System.out.println("bean2.bean4.age = " + bean2.getBean4().getAge());
        System.out.println("=================================================");
        System.out.println("bean2.bean5.address = " + bean2.getBean5().getAddress());
    }

    @Test
    public void testBeanFunc2(){

        Bean2 bean2 = (Bean2)applicationContext.getBean("bean2");
        Bean2 bean2_1 = (Bean2)applicationContext.getBean("bean2");

        if(bean2 == bean2_1){
            System.out.println("==");
        }else{
            System.out.println("!=");
        }
    }


}
