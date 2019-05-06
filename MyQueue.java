package coms;

/**
 * Autor : dong
 * Time:2019/4/13
 */
public class MyQueue {
    //先入先出
    private class Node{
        int value;
        Node next;
    }


    Node head;
    Node last;

    MyQueue(){

        this.head = this.last = null;
    }
    //入队列,插入到队尾
    public void push(int v){
        Node node = new Node();
        node.value = v;
        node.next = null;
        if(this.head == null){
            this.head = this.last =null;
        }else{
            this.last.next = this.last = node;
        }
    }
    //出队列
    public int pop(){
        int v = this.head.value;
        this.head = this.head.next;
        if(this.head == null){
            this.last = null;
        }
        return v;
    }

    //返回队首元素
    public int front(){
        return this.head.value;
    }

    public int size(){
        return 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

}




























