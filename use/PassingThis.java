package com.use;

/**
 * Autor : dong
 * Time:2018/12/19
 */
//吃水果的人
class Person{
    public void eat(Apple apple){
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");

    }
}
//削皮的人
class Peeler{
    static Apple peel(Apple apple){
        return apple;//Peeled
    }
}
//苹果
class Apple{

    public  Apple getPeeled(){
        return Peeler.peel(this);
    }
}
//实现
public class PassingThis {
    public static void main(String[] args) {
        Person person = new Person();
        Apple apple = new Apple();
        person.eat(apple);
    }
}
