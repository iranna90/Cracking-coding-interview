package strings;

import java.util.Arrays;

public class RemoveDuplicateCharactersFromInput {

    public static void main(String[] args) {
        char[] input = {'a', 'a', 'b', 'c', 'd', 'c', 'e'};
        System.out.println(removeDuplicate(input));
    }

    private static char[] removeDuplicate(char[] input) {

        if (input == null || input.length < 2) {
            return input;
        }

        boolean[] characters = new boolean[256];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            char character = input[i];
            // already exists, so ignore
            if (characters[character]) {
                continue;
            }

            // set character already processed
            characters[character] = true;
            input[index] = character;
            index++;
        }

        return Arrays.copyOf(input, index);
    }
}
