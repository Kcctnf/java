package com.list;

import java.util.*;

/**
 * Autor : dong
 * Time:2018/12/12
 */

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String toString() {
        return "{" + "mame=" + name + "age=" + age + "}";
    }

//手工自己写的equals方法
    /*@Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o instanceof Person) {
            Person that = (Person) o;//强转
            return this.getName().equals(that.getName()) && this.getAge().equals(that.getAge());
        }
        return false;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}

//List是一个接口，实现他的类主要有arrayList   LinkedList等等
public class TestList {
    public static void code1() {
        List<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        //num.add(1);//List可以重复元素
        System.out.println(num);

        num.add(3, 2);
        System.out.println(num);

        System.out.println(num.isEmpty());//列表中不包含元素返回true   else  返回false
        System.out.println(num.size());

        num.addAll(num);
        System.out.println(num);
        System.out.println(num.remove(2));
        System.out.println(num.remove(6));

/*
        System.out.print("[");
        for (int i = 0, len = num.size(); i < len; i++) {
            System.out.print(num.get(i));
            if (i < len - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
*/
/*
        System.out.print("[");
        for (Integer item : num) {
            System.out.print(", ");
            System.out.print(item);
            System.out.print("]");
        }
        System.out.println();


        //迭代器接口
        Iterator<Integer> interator = num.iterator();
        while (interator.hasNext()) {
            System.out.print(interator.next());
            System.out.print(", ");

*/
        //       }


        //数据结构：List ->  ArrayList
        //1.ArrayList的数据是通过数组存放
        //2.ArrayList的默认构造方法实例化，
        //存储数据的数组初始化时在第一次添加元素时进行(lazy load) -扩容-50% -默认容量10
        //3.ArrayLis的初始化容量的构造方法实例化，存储数据的数组立即初始化

        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        String str = scanner.nextLine();


        Object[] elementArray = num.toArray();
        Integer[] elementArray1 = new Integer[num.size()];
        for (int i = 0, len = num.size(); i < len; i++) {
            elementArray[i] = num.get(i);
            System.out.print(elementArray[i]);
        }
    }

    public static void main(String[] args) {


    }
}
