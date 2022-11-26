package Stack;

import java.util.Stack;

// HARD
public class maxAreaHitogram {

    public static void find_maxArea(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] right = new int[arr.length];

        // right
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty())
                right[i] = arr.length;
            else
                right[i] = s.peek();
            s.push(i);
        }

        s.clear(); // or s = Stack<>(); 
        System.out.println(s.isEmpty());

        // left
        int[] left = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty())
                left[i] = -1;
            else
                left[i] = s.peek();
            s.push(i);
        }


        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * arr[i]);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        // Given heights of histogram's bar, return the max area
        int arr[] = { 2, 1, 5, 6 ,2, 3};
        // ans = 10
        /*
         * for each element: check next smaller to right and left
         * 2 -> 2 * 1 = 2
         * 1 -> 1 * 6 = 6
         * 5 -> 5 * 2 = 10
         * 6 -> 6 * 1 = 6
         * 2 -> 2 * 4 = 8
         * 3 -> 3 * 1 = 3
         */

        find_maxArea(arr);
    }
}
