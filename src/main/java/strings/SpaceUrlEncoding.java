package strings;

import java.util.Arrays;

/*
Write a method to replace all spaces in a string with ‘%20’
 */
public class SpaceUrlEncoding {
    public static void main(String[] args) {
        char[] input = new char[10];
        input[0] = 'a';
        input[1] = ' ';
        input[2] = 'b';
        input[3] = ' ';
        input[4] = 'c';
        input[5] = 'd';
        System.out.println(input);
        System.out.println(encode(input));
    }

    // "a b c"  --> "a%20b%20c"
    private static char[] encode(char[] input) {
        int newLength = input.length - 1;
        for (int i = input.length - 1; i >= 0; i--) {
            char c = input[i];

            if (c == '\0') {
                continue;
            }

            if (c == ' ') {
                input[newLength] = '0';
                newLength--;
                input[newLength] = '2';
                newLength--;
                input[newLength] = '%';
                newLength--;
            } else {
                input[newLength] = c;
                newLength--;
            }
        }

        return input;
    }
}
