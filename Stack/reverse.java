package Stack;

import java.util.Stack;

/**
 * reverse
 */
public class reverse {

    public static void pushInBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int temp = s.pop();
        pushInBottom(s, data);
        s.push(temp);
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushInBottom(s, top);
    }  

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        reverseStack(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}