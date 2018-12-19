package com.dzexercise;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Autor : dong
 * Time:2018/12/18
 */
public class TestQueue {


    public static void code1() {
        //LinkedList 左边类型 Queue
        Queue<String> queue = new LinkedList<>();
        System.out.println("队列的元素是否为空：" + queue.isEmpty());
        //入队列
        queue.add("Java");
        queue.add("C++");

        System.out.println("队列的元素是否为空：" + queue.isEmpty());
        queue.add("PHP");
        System.out.println("队列的元素数量：" + queue.size());

        //查看队头
        System.out.println("队头元素时：PHP " + "PHP".equals(queue.peek()));//false

        //出队列
        //pop 当作栈使用
        //poll 队列
        System.out.println(queue.poll());//Java
        System.out.println(queue.poll());//C++
        System.out.println(queue.poll());//PHP
        System.out.println(queue.poll());//null
    }

    public static void main(String[] args) {

        //生产者-消费者模型
        //生产者和消费者的能力不匹配（生产的速度和消费的速度不匹配）
        //采用队列的方式存在生产消费的资源（元素），解耦生产者和消费者的实现逻辑
        //main
        Queue<String> queue = new LinkedList<>();


        //生产者
        new Thread(new Runnable() {
            {
                System.out.println("生产者线程启动");
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                        //生产数据
                        String data = String.valueOf(Math.random());
                        System.out.println("生产：" + data);
                        queue.add(data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {

            {
                System.out.println("消费者线程");
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        System.out.println("消费：" + queue.poll());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            int in = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
