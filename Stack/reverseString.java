package Stack;
import java.util.*;

/**
 * reverseString
 */
public class reverseString {
    public static void main(String[] args) {
        String str = "reverse This String";
        
        Stack<Character> sk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            sk.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder("");
        while (!sk.isEmpty()) {
            sb.append(sk.pop());
        }

        System.out.println(sb.toString());
    }
}