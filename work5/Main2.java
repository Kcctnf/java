package dong.work5;

/**
 * Author : dong
 * Time:2019/5/31
 */

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Main2 {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1 || s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '[' || a == '{') {
                stack.push(a);
            }
            if (a == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (a == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (a == '}' && stack.peek() == '{') {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String s = "(()])}[}[}[]][}}[}{})][[(]({])])}}(])){)((){";
        System.out.println(isValid(s));
    }
}
