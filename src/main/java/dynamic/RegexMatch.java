public class RegexMatch {
    /*

    * => Matches zero or more characters
    . => Matches one characters

     */
    public static void main(String[] args) {
        String input = "ABBBAC";
        String regex = ".*A*";
        System.out.println(rem(input, input.length(), regex, regex.length()));
    }

    /*



     */
    private static boolean rem(String input, int i, String regex, int j) {

        if ((i == -1 && j == -1) || regex.substring(0, j).equals("*")) {
            return true;
        }

        if (i == -1) {
            return false;
        }

        char regexCharacter = regex.charAt(j - 1);

        if (regexCharacter == '.') {
            return rem(input, i - 1, regex, j - 1);
        }

        if (regexCharacter == input.charAt(i - 1)) {
            return rem(input, i - 1, regex, j - 1);
        }

        if (regexCharacter == '*') {
            boolean noMatch = rem(input, i, regex, j - 1);
            boolean oneMatch = rem(input, i - 1, regex, j);
            return noMatch || oneMatch;
        }

        return false;
    }
}
