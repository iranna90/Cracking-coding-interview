package dynamic;

public class MinimumDeletionPalindrom {


    public static void main(String[] args) {
        String input = "abdcda";
        System.out.println(mdp(input, 0, input.length() - 1));
    }

    /*
       mdp(i,j)
          i==j ==> mdp[i-1][j-1]

    */
    private static int mdp(String input, int start, int end) {
        if (start == end || start > end || (end - start) == 1) {
            return 0;
        }

        if (input.charAt(start) == input.charAt(end)) {
            return mdp(input, start + 1, end - 1);
        }

        return 1 + Math.min(mdp(input, start + 1, end), mdp(input, start, end - 1));
    }
}
