package dynamic.twodimensional;

public class MinDeletionPalidrom {
    public static void main(String[] args) {
        String input = "abcdb";
        System.out.println(minPal(input, 0, input.length() - 1));
        System.out.println(iterative(input));
    }

    /*
    Solution is
      * start with begin and end index,
        -- each step
         check begin and last characters are same.
          yes -- no need to delete, just continue with begin+1 and end-1
          no --- you can delete either item at the beginning or item at the end
            min(pal(begin+1, end), pal(begin, end-1))
     */
    private static int minPal(String input, int beginIndex, int endIndex) {

        if (beginIndex == endIndex) {
            return 0;
        }

        if (input.charAt(beginIndex) == input.charAt(endIndex)) {
            return minPal(input, beginIndex + 1, endIndex - 1);
        }

        return 1 + Math.min(
                minPal(input, beginIndex + 1, endIndex),
                minPal(input, beginIndex, endIndex - 1)
        );
    }

    /*
    i,j ====  if c[i] == c[j] -----> dp[i][j]
    i != j -----> 1 + min(dp[i+1][j], dp[i][j-1])
     */
    private static int iterative(String input) {
        int[][] result = new int[input.length()][input.length()];

        // check each length
        for (int length = 1; length <= input.length(); length++) {

            // check all possible window of above length.
            for (int beginIndex = 0; beginIndex <= input.length() - length; beginIndex++) {

                // if selected length is n we need to define the end index as (start + n - 1) as the index starts with 0 in array
                int endIndex = beginIndex + length - 1;

                if (beginIndex == endIndex) {
                    continue;
                }

                if (input.charAt(beginIndex) == input.charAt(endIndex)) {
                    result[beginIndex][endIndex] = result[beginIndex + 1][endIndex - 1];
                } else {
                    result[beginIndex][endIndex] = 1 + Math.min(result[beginIndex + 1][endIndex], result[beginIndex][endIndex - 1]);
                }
            }
        }


        return result[0][input.length() -1];
    }
}
