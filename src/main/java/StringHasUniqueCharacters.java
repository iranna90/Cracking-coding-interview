import java.util.HashSet;
import java.util.Set;

public class StringHasUniqueCharacters {
    public static void main(String[] args) {
        String input = "abcdef";
        System.out.println(isUniqueCharacters(input));
        System.out.println(isUniqueCharactersLessSpace(input));

        input = "abcdefa";
        System.out.println(isUniqueCharacters(input));
        System.out.println(isUniqueCharactersLessSpace(input));

        input = "aa";
        System.out.println(isUniqueCharacters(input));
        System.out.println(isUniqueCharactersLessSpace(input));
    }

    private static boolean isUniqueCharacters(String input) {
        if (input == null || input.length() < 2) {
            return true;
        }

        // with space
        // time complexity is O(n)
        // space complexity is O(n)
        Set<Character> visited = new HashSet<>(); // boolean instead of character 8 byte to 1 bit
        for (int i = 0; i < input.length(); i++) {
            final char character = input.charAt(i);
            if (visited.contains(character)) {
                return false;
            }

            visited.add(character);
        }
        return true;
    }

    private static boolean isUniqueCharactersLessSpace(String input) {
        if (input == null || input.length() < 2) {
            return true;
        }
        // 2 for loop is one way which will result in O(n^2)

        // considering only characters allowed are 'a' to 'z'
        // consider 'a' as the element at 0th position in integer and 'z' as 26th
        int visitedCharacters = 0;
        for (int i = 0; i < input.length(); i++) {
            final char character = input.charAt(i);
            int positionOfTheCharacter = character - 'a';
            int itemPosition = 1 << positionOfTheCharacter;
            if ((visitedCharacters & itemPosition) > 0) {
                return false;
            }

            visitedCharacters = visitedCharacters | itemPosition;
        }

        return true;
    }

}
