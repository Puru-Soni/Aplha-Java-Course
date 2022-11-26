package BackTracking;

public class findPermu {

    //  Time : O(n * n!)
    public static void findAllPermutations(String str, String ans){
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursion
        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i+1);
            findAllPermutations(newstr, ans+curr);
        }
    }
    public static void main(String[] args) {
        // Find Permutations of Strings:
        // input = "abc"
        // o/p : abc, acb, bac, cab, cba // n!, n = length of string
        // ans = "" str = "abc" each char can be placed at each posi.
        /*
                              abc
                         /     |    \
                        a      b      c                      
                      /  \    / \     / \
                     ab  ac  ba  bc  ca  cb
                     |   |   |   |   |   |
                    abc acb bac bca cab cba  (3! = 6)             
        */
        String str = "abc";
        findAllPermutations(str, "");
    }
}