public class LongestSubstring {
    public static void main(String[] args) {
        String input1 = "abadab";
        String input2 = "abacabb";
        System.out.println(mss(input1, input1.length() - 1, input2, input2.length() - 1, 0));
        System.out.println(linear(input1, input2));
    }

    /*
    base i<0 or j<0 ==> 0

    if(c[i] == c[j]) ===> max(1+mss(i-1,j-1), mss(i-1,j), mss(i, j-1)
    else ===> max(mss(i-1), mss(i,j-1))
     */
    private static int mss(String input1, int index1, String input2, int index2, int result) {
        if (index1 < 0 || index2 < 0) {
            return result;
        }

        int withoutI = mss(input1, index1 - 1, input2, index2, 0);
        int withoutJ = mss(input1, index1, input2, index2 - 1, 0);
        int max = Math.max(withoutI, withoutJ);

        if (input1.charAt(index1) == input2.charAt(index2)) {
            int count = mss(input1, index1 - 1, input2, index2 - 1, result + 1);
            return Math.max(count, max);
        }

        return max;
    }

    /*
     i == j
       dp[i][j] = max(1+dp[i-1[j-1], dp[i-1][j], dp[i][j-1])
       dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     */
    private static int linear(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // find maximum
        int max = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
