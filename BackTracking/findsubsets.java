package BackTracking;

/*
 * Decision : True/False based
 * Optimization : optimize a approach
 * Enumeration : all possible solution
 */

public class findsubsets {
    // Time : O(2^n * n)
    // Space : O(n)

    // Decision Based Tree : char want to add, or not
    /*
                                abc
                                / \
        for a           (yes) a    "" (no)
                          / \         / \
        for b           ab   a       b    ""
                       / \   / \    / \   / \
        for c       abc  ab ac  a  bc  b c   ""    
    
    */
    public static void getSubSets(String str, int index, String ans) {
        if (index == str.length()) {
            if (ans.length() == 0)
                System.out.println("null");
            else
                System.out.println(ans);
            return;
        }
        getSubSets(str, index + 1, ans + str.charAt(index));
        getSubSets(str, index + 1, ans);
    }

    public static void main(String[] args) {
        String str = "abc";
        // o/p : a, b, c, ab, bc, ca, abc, ""(null)
        // length of string = n, subsets => 2^n

        getSubSets(str, 0, "");
    }
}