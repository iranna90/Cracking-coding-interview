public class EditDistance {
    public static void main(String[] args) {
        String s1 = "GET";
        String s2 = "GOTBXA";
        System.out.println(minimumEdit(s1, s1.length() - 1, s2, s2.length() - 1));
        System.out.println(linear(s1, s2));
    }

    private static int minimumEdit(String s1, int i, String s2, int j) {
        if (i < 0 && j < 0) {
            return 0;
        }

        if (i < 0) {
            return j;
        }

        if (j < 0) {
            return i;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return minimumEdit(s1, i - 1, s2, j - 1);
        }

        int insert = 1 + minimumEdit(s1, i - 1, s2, j);
        int replace = 1 + minimumEdit(s1, i - 1, s2, j - 1);
        int remove = 1 + minimumEdit(s1, i, s2, j - 1);
        return Math.min(insert, Math.min(replace, remove));
    }

    /*
        base case when ant of them does not have string other will get all the characters

        if a[i] == a[j]
          med[i][j] = med[i-1][j-1]

        1 + min(med[i-1][j], med[i-1][j-1], med[i][j-1])

     */

    private static int linear(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // base condition
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                // when first string ended, remaining characters from the next should take
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }

                // when second ended, remaining from first
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                // characters same then move both pointers
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                // characters not same then insert, replace and remove
                int insert = dp[i - 1][j];
                int replace = dp[i - 1][j - 1];
                int delete = dp[i][j - 1];

                dp[i][j] = 1 + Math.min(insert, Math.min(replace, delete));
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
