package com.dongs;

/**
 * Autor : dong
 * Time:2018/12/11
 */

class Message<T> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}


public class TestDemo {
    public static void fun(Message<String> temp) {
        System.out.println(temp.getMessage());
    }

//    public static void fun1(Message<Integer> temp) {
//        System.out.println(temp.getMessage());
//   }

    public static void main(String[] args) {
        Message<String> message = new Message();
        message.setMessage("比特科技欢迎您");
        fun(message);


        Message<Integer> message1 = new Message();
        message.setMessage(100);
        fun(message1); // 出现错误，只能接收String
    }
//引出通配符“？”
}

