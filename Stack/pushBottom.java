package Stack;

import java.util.Stack;

public class pushBottom {
    
    public static void insertInBottom(Stack<Integer> sk, int data) {
        if (sk.isEmpty()) {
            sk.push(data);
            return;
        } else {
            int temp = sk.pop();
            insertInBottom(sk, data);
            sk.push(temp);
        }   
    }
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // push 4 at bottom:
        insertInBottom(s, 4);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
