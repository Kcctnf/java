package com.dongs;

/**
 * Autor : dong
 * Time:2018/12/12
 */
//设置泛型上限，可以用在声明，，，不能修改
class Message1<T extends Number> {
    private T message1;

    public T getMessage1() {
        return message1;
    }

    public void setMessage1(T message1) {
        this.message1 = message1;
    }
}


class Message2<T> {
    private T message2;

    public T getMessage2() {
        return message2;
    }

    public void setMessage2(T message2) {
        this.message2 = message2;
    }

    @Override
    public String toString() {
        return "Message2{" +
                "message2=" + message2 +
                '}';
    }
}

public class TestDemo1 {
    public static void fun(Message1<? extends Number> temp) {
        //此处不能修改
        System.out.println(temp.getMessage1());

    }

    //设置泛型下限    只能用在方法参数，可以修改内容
    public static void fun1(Message2<? super String> temp) {
        temp.setMessage2("zizi");//此时可以修改
        System.out.println(temp.getMessage2());
    }

    public static void main(String[] args) {
        Message1<Integer> message1 = new Message1();
        message1.setMessage1(100);
        fun(message1);
        Message1<Double> message2 = new Message1<Double>();
        System.out.println();


        Message2<String> message3 = new Message2<>();
        message3.setMessage2("hahah");
        //fun1(message3);  out--->  zizi
        System.out.println(message3);
        // out ------>  hahah



    }

}
