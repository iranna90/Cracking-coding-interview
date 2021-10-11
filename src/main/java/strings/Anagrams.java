package strings;

public class Anagrams {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abdc";
        System.out.println(isAnagrams(s1, s2));

        s1 = "ab";
        s2 = "aa";
        System.out.println(isAnagrams(s1, s2));

        s1 = "aaaaabaa";
        s2 = "aaaaabbb";
        System.out.println(isAnagrams(s1, s2));
    }


    /*
    Have same characters but in different locations
     */
    private static boolean isAnagrams(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[256];
        // first string all items are counted
        for (char character : s1.toCharArray()) {
            count[character] += 1;
        }

        for (char character : s2.toCharArray()) {
            count[character] -= 1;
        }

        for (int item : count) {
            if (item != 0) {
                return false;
            }
        }

        return true;
    }
}
