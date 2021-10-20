package array;

import java.util.HashSet;
import java.util.Set;

/*
Implement an algorithm to determine if a string has all unique characters What if you can not use additional data structures?
 */
public class UniqueCHaracters {
    public static void main(String[] args) {
        System.out.println(isUniqueCharacters("abcdefgh"));
        System.out.println(isUniqueCharacters("abcdefghh"));
        System.out.println(isUniqueCharacters(""));
        System.out.println(isUniqueCharacters(null));

        System.out.println(withoutMemory("abcdefgh"));
        System.out.println(withoutMemory("abcdefghh"));
        System.out.println(withoutMemory(""));
        System.out.println(withoutMemory(null));


        System.out.println(withVariable("abcdefgh"));
        System.out.println(withVariable("abcdefghh"));
        System.out.println(withVariable(""));
        System.out.println(withVariable(null));

        int a = 1;

        int b = a << 31;
        int c = a << 32;
        System.out.println(c);


    }

    // using memory of fixed size which is 256 bits.
    private static boolean isUniqueCharacters(String input) {

        boolean[] memory = new boolean[256];
        if (input == null || input.length() <= 1) {
            return true;
        }

        for (char c : input.toCharArray()) {
            boolean exists = memory[c];
            if (exists) {
                return false;
            }
            memory[c] = true;
        }

        return true;
    }

    // without any memory ==== O(n^2)
    private static boolean withoutMemory(String input) {

        if (input == null || input.length() <= 1) {
            return true;
        }
        // abcdefgh
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = i + 1; j < input.length(); j++) {
                char nextChar = input.charAt(j);
                if (c == nextChar) {
                    return false;
                }
            }
        }

        return true;
    }


    // assumption here is only allowed characters are are only lower case 'a to z' only 26 characters.
    private static boolean withVariable(String input) {
        int memory = 0;
        if (input == null || input.length() <= 1) {
            return true;
        }

        for (char c : input.toCharArray()) {
            int position = c - 'a';
            int newItem = 1 << position;
            int alreadyExists = memory & newItem;
            if (alreadyExists > 0) {
                return false;
            }

            memory = memory | newItem;
        }

        return true;
    }
}
