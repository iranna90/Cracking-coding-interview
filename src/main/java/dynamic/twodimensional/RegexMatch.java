package dynamic.twodimensional;

/*
Check given string matches the regex or not
A-Z ---> character match
0-9 ---> Number match
.   ---> Matches one character
*   ---> Matches 0 or more characters
 */
public class RegexMatch {
  private static final char STAR = '*';
  private static final char DOT = '.';

  public static void main(String[] args) {
    String input = "ABBBAC";
    String regex = "*.*A*";
    System.out.println(match(input, input.length() - 1, regex, regex.length() - 1));
    System.out.println(iterative(input, regex));
    System.out.println(bottomUp(input, regex));
  }

  private static boolean match(String input, int inputIndex, String regex, int regexIndex) {

    if (inputIndex == -1 && regexIndex == -1) {
      return true;
    }

    // in regex only left is * so everything matches
    if (isOnlyStarLeft(regex, regexIndex)) {
      return true;
    }

    if (inputIndex == -1 || regexIndex == -1) {
      return false;
    }

    char inputChar = input.charAt(inputIndex);
    char regexChar = regex.charAt(regexIndex);

    if (inputChar == regexChar) {
      return match(input, inputIndex - 1, regex, regexIndex - 1);
    }

    if (regexChar == DOT) {
      return match(input, inputIndex - 1, regex, regexIndex - 1);
    }

    if (regexChar == STAR) {
      return match(input, inputIndex, regex, regexIndex - 1) || match(input, inputIndex - 1, regex, regexIndex);
    }

    return false;
  }

  private static boolean isOnlyStarLeft(final String regex, final int regexIndex) {
    for (int i = regexIndex; i >= 0; i--) {
      if (regex.charAt(i) != STAR) {
        return false;
      }
    }

    return true;
  }

  private static boolean iterative(String input, String regex) {
    boolean[][] result = new boolean[input.length() + 1][regex.length() + 1];
    result[0][0] = true;

    // Only '*' can match with empty string
    for (int j = 1; j <= regex.length(); j++) {
      if (regex.charAt(j - 1) == '*') {
        result[0][j] = result[0][j - 1];
      }
    }

    for (int i = 1; i <= input.length(); i++) {
      for (int j = 1; j <= regex.length(); j++) {
        char inputChar = input.charAt(i - 1);
        char regexChar = regex.charAt(j - 1);
        if (inputChar == regexChar) {
          result[i][j] = result[i - 1][j - 1];
        } else if (regexChar == DOT) {
          result[i][j] = result[i - 1][j - 1];
        } else if (regexChar == STAR) {
          result[i][j] = result[i - 1][j] || result[i][j - 1];
        } else {
          result[i][j] = false;
        }
      }
    }

    return result[input.length()][regex.length()];
  }

  private static boolean bottomUp(String S, String R) {
    int M = S.length();
    int N = R.length();
    boolean[][] dp = new boolean[M+1][N+1];

    dp[0][0] = true;

    for (int i=1; i<= M; i++) {
      for (int j=1; j <=N; j++) {
        if (S.charAt(i-1) == R.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else if(R.charAt(j-1) == '.') {
          dp[i][j] = dp[i-1][j-1];
         } else if(R.charAt(j-1) == '*') {
          dp[i][j] = dp[i-1][j] || dp[i][j-1];
        }
      }
    }

    return dp[M][N];
  }
}
