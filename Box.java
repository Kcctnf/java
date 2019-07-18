package xiaodong;

import java.util.*;

/**
 * Author : dong
 * Time:2019/7/15
 */

/**
 * 双栈实现一个队列
 */

class StackQueen{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push1(int node){

        stack1.push(node);
    }

    public int pop1(){

        if(stack2.empty()){
            while(!stack1.empty())
                stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

}

/**
 * 双队列实现一个栈
 */
class QueueStack{
    LinkedList<Integer> linkedList1 = new LinkedList<>();
    LinkedList<Integer> linkedList2 = new LinkedList<>();

    public boolean isEmpty(){
        return linkedList1.isEmpty()&&linkedList2.isEmpty();
    }

    public void push(Integer data){
        linkedList1.add(data);
    }

    public int pop(){
        if(linkedList1.size() == 1){
            return linkedList1.poll();
        }
        else{
            while(linkedList1.size() > 1){
                linkedList2.add(linkedList1.poll());
            }
            //int tem = linkedList1.poll();
            while(!linkedList2.isEmpty()){
                linkedList1.add(linkedList2.poll());
            }
            return linkedList1.pop();
        }

    }



}

/**
 * 测试类
 */
public class Box {

    public static void main(String[] args) {

        StackQueen stackQueen = new StackQueen();
        stackQueen.push1(1);
        stackQueen.push1(2);
        stackQueen.push1(3);
        stackQueen.push1(4);

        for(int i = 0;i < 4;i++){
            System.out.println(stackQueen.pop1());
        }


        QueueStack queueStack = new QueueStack();
        queueStack.push(5);
        queueStack.push(6);
        queueStack.push(7);
        queueStack.push(8);

        for(int i = 0;i < 4;i++){
            System.out.println(queueStack.pop());
        }




    }
}
