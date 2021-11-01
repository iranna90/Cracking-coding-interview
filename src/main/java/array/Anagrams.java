package array;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        boolean result = Anagrams.anagram("aba", "baaa");
        System.out.println(result);
        String i = "ab cd x"; // ab%20cd%20x
    }

    /*
    a= "abcdaa"
    b= "cadbaa"
     */
    private static boolean anagram(String a, String b) {
        Map<Character, Integer> count = new HashMap<>();

        // counting each character from a
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (count.containsKey(c)) {
                Integer integer = count.get(c);
                count.put(c, integer + 1);
            } else {
                count.put(c, 1);
            }
        }

        // decreasing each character from b
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            Integer integer = count.get(c);
            count.put(c, integer - 1);
        }

        for (Integer value : count.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
