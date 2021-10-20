package basic;

import java.util.HashMap;
import java.util.Map;

/*
s= abbc
b= cbabadcbbabbcbabaabccbabc
 */
public class PermutationOfSInB {
  public static void main(String[] args) {
    String s = "abbc";
    String b = "cbabadcbbabbcbabaabccbabc";
    permutation(s, b);
  }

  private static void permutation(String s, String b) {

    int totalPermutation = 0;

    Map<Character, Integer> count = new HashMap<>();
    for (Character c : s.toCharArray()) {
      count.merge(c, 1, Integer::sum);
    }

    // s = abbc
    // b = abbcad
    int endIndex = b.length() - (s.length() - 1);
    for (int i = 0; i < endIndex; i++) {
      if (isPermutation(s, b, new HashMap<>(count), i)) {
        totalPermutation += 1;
      }
    }

    System.out.println(totalPermutation);
  }

  private static boolean isPermutation(final String s,
                                       final String b,
                                       final HashMap<Character, Integer> count,
                                       final int startLocation) {

    int endLocation = startLocation + s.length();
    for (int i = startLocation; i < endLocation; i++) {
      Character c = b.charAt(i);
      Integer integer = count.get(c);
      if (integer == null || integer < 1) {
        return false;
      }
      count.put(c, integer - 1);
    }

    for (Map.Entry<Character, Integer> entry : count.entrySet()) {
      if (entry.getValue() != 0) {
        return false;
      }
    }

    return true;
  }
}
