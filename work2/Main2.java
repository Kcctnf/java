package dong.work2;

import java.util.Stack;
/**
 * Author : dong
 * Time:2019/5/26
 */


/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Main2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int n) {
        stack1.push(n);
    }

    public int pop() throws Exception {
        if (stack1.empty() && stack2.empty()) {

            throw new Exception();
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                return stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {

    }
}
