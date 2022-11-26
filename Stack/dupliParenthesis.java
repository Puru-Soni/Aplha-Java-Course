package Stack;

import java.util.Stack;
public class dupliParenthesis {

    // O(n)
    public static boolean checkDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            // closing
            if (curr == ')') {
                int cnt = 0;
                while (s.pop() != '(') {
                    cnt++;
                }
                if (cnt < 1)
                    return true;
            }
            // opening, operators, operands
            else
                s.push(curr);
        }
        return false;
    }

    public static void main(String[] args) {

        // Given a balanced expression:
        // Find if it contains duplicate paranthese or not.
        // if same subexpression is surronded by mupliple brackets.

        // EX : (((a+(b)))+(c+d)) True
        // Ex: (((a+b)) + c) True
        // Ex: ((a+b)+(c+d)) False

        // String str = "((a+b)+(c+d))";
        String str = "(((a+(b)))+(c+d))";
        // Paranthese that do not contain any expression

        boolean a = checkDuplicate(str);
        System.out.println(a);
    }
}
