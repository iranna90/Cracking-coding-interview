package dynamic.twodimensional;

public class CommonSubSequence {
    public static void main(String[] args) {
        String first = "ACHEMGLP";
        String second = "XYCEPQMLG";
        System.out.println(cs(first, first.length() - 1, second, second.length() - 1));
        System.out.println(iterative(first, second));
    }

    private static int cs(String first, int firstIndex, String second, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0) {
            return 0;
        }

        if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
            return 1 + cs(first, firstIndex - 1, second, secondIndex - 1);
        }

        return Math.max(
                cs(first, firstIndex - 1, second, secondIndex),
                cs(first, firstIndex, second, secondIndex - 1)
        );
    }

    /*

    char[i] == char[j] = 1+ result[i-1][j-1]
     if not  == min(result[i-1][j], result[i][j-1])
     */

    private static int iterative(String first, String second) {
        int[][] result = new int[first.length() + 1][second.length() + 1];
        for (int firstIndex = 1; firstIndex <= first.length(); firstIndex++) {
            for (int secondIndex = 1; secondIndex <= second.length(); secondIndex++) {
                if (first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1)) {
                    result[firstIndex][secondIndex] = 1 + result[firstIndex - 1][secondIndex - 1];
                } else {
                    result[firstIndex][secondIndex] = Math.max(result[firstIndex - 1][secondIndex], result[firstIndex][secondIndex - 1]);
                }
            }
        }

        return result[first.length()][second.length()];
    }
}
