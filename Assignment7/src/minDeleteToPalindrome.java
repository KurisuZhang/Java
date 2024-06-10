public class minDeleteToPalindrome {
    public static int minDeletionsToPalindrome(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    private static void test(String s, int expected) {
        int result = minDeletionsToPalindrome(s);
        if (result == expected) {
            System.out.println("Test passed for input: " + s);
        } else {
            System.out.println("Test failed for input: " + s + ". Expected: " + expected + ", but got: " + result);
        }
    }

    public static void main(String[] args) {
        String s = "aebcbda";
        System.out.println("Minimum deletions: " + minDeletionsToPalindrome(s));
        test("aebcbda", 2); 
        test("abca", 1);   
        test("racecar", 0);
        test("abcdef", 5);  
        test("madam", 0);   
        test("aabb", 2);  
        test("abcdeca", 2);  
        test("abcd", 3);     
        test("a", 0);       
        test("", 0);        
    }
}
