package Stack;

import java.util.Stack;

public class validParenthesis {

    public static boolean check(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                s.push(')');
            else if (str.charAt(i) == '[')
                s.push(']');
            else if (str.charAt(i) == '{')
                s.push('}');
            else if (!s.isEmpty() && s.peek() == str.charAt(i))
                s.pop();
            else
                return false;
        }
        if (s.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String str = "((){}[]])";
        System.out.println( check(str) );
    }
}
