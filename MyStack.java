package coms;

/**
 * Autor : dong
 * Time:2019/4/13
 */
public class MyStack {

    private int[] p;
    int top;

    MyStack(){
        this.p = new int[100];
        this.top = 0;
    }

    //押入一个数据或插入一个数据
    public void push(int v){
        this.p[this.top++] = v;
    }
    //弹栈，出栈
    public int pop(){
        return this.p[--this.top];
    }
    //查看栈顶元素
    public int peek(){
        return this.p[this.top - 1];
    }

    public int size(){
        return this.top;
    }
    public boolean isEmpty(){
        return this.top == 0;
    }

}
