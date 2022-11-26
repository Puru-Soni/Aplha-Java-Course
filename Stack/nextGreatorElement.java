package Stack;

import java.util.Stack;

/* -------------------------------- IMPORTANT ------------------------------- */

public class nextGreatorElement {

    public static int[] bruteForce(int[] arr) {
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int temp = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > curr) {
                    temp = arr[j];
                    break;
                }
            }
            res[i] = temp;
        }
        return res;
    }

    public static int[] optimized(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) { // reverse Traversing
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty())
                ans[i] = -1;
            else
                ans[i] = s.peek();
            s.push(arr[i]);
        }
        return ans;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        // The next greator element of some element x in an array is
        // The first greator element that is to the right of x in the same array

        /*
         * EX: [6,8,0,1,3]
         * o/p = [8, -1, 1, 3, -1]
         * 
         * // Brute Force : O(n*n)
         */

        int arr[] = { 6, 8, 0, 1, 3 };
        int[] res = bruteForce(arr); // O(n*n)
        print(res);

        int[] ans = optimized(arr); // O(n)
        print(ans);
    }

}
