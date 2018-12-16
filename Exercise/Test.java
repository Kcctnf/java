package com.Exercise;

/**
 * Autor : dong
 * Time:2018/12/14
 */
//Set 不能有重复的元素，且是无序的，要有空值也就只能有一个。因为它不允许重复。
// List 可以有重复元素，且是有序的，要有空值也可以有多个，因为它可重复


public class Test {
    private static int i = 1;
    //因为i是static的，是类属性，所以不管有多少对象，都共用的一个变量。
    // 这里getNext()方法被调用了三次，所以进行了三次i++操作。
    public int getNext() {
        return i++;
    }

    public static void main(String[] args) {
        Test test = new Test();
        Test testObject = new Test();
        test.getNext();
        testObject.getNext();
        System.out.println(testObject.getNext());
    }
}
