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
        test("aebcbda", 2);  // 删除 'e' 和 'd' 或 'a' 和 'a'
        test("abca", 1);     // 删除 'c' 或 'b'
        test("racecar", 0);  // 已经是回文
        test("abcdef", 5);   // 删除 'a', 'b', 'c', 'd', 'e' 或者 'b', 'c', 'd', 'e', 'f'
        test("madam", 0);    // 已经是回文
        test("aabb", 2);     // 删除两个 'a' 或两个 'b'
        test("abcdeca", 2);  // 删除 'b', ', 'e' 或其他组合acdca
        test("abcd", 3);     // 删除 'a', 'b', 'c' 或其他组合
        test("a", 0);        // 单个字符已经是回文
        test("", 0);         // 空字符串已经是回文
    }
}
