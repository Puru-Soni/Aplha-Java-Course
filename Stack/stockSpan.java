package Stack;

import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {
        // Given stock, required Span
        // Span - max no of consecutive days for which : price <= today's price

        // span = i-prev_High
        int arr[] = { 100, 80, 60, 70, 60, 85, 100 };

        Stack<Integer> s = new Stack<>();
        s.push(0);
        System.out.println(1);
        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty())
                System.out.println(i+1);
            else
                System.out.println(i - s.peek());
            s.push(i);
        }
    }
}















