package dynamic.onedimensional.dp;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BreakStringFromDictionary {
  public static void main(String[] args) {
    String s = "pineapplepenapple";
    Set<String> dic = Stream.of("apple", "pen", "applepen", "pine", "pineapple").collect(Collectors.toSet());
    AtomicInteger count = new AtomicInteger();
    System.out.println(ways(s, dic, s.length() - 1, count) + " times " + count.get());

    count = new AtomicInteger();
    System.out.println(waysMemo(s, dic, s.length() - 1, count, new int[s.length()]) + " times " + count.get());

    System.out.println(iterative(s, dic));
  }

  private static int ways(String s, Set<String> d, int index, AtomicInteger count) {
    if (index < 0) {
      return 1;
    }

    count.incrementAndGet();

    int way = 0;
    for (int i = index; i >= 0; i--) {
      if (d.contains(s.substring(i, index + 1))) {
        way = way + ways(s, d, i - 1, count);
      }
    }

    return way;
  }

  private static int waysMemo(String s, Set<String> d, int index, AtomicInteger count, int[] memo) {
    if (index < 0) {
      return 1;
    }

    if (memo[index] != 0) {
      return memo[index];
    }

    count.incrementAndGet();

    int way = 0;
    for (int i = index; i >= 0; i--) {
      if (d.contains(s.substring(i, index + 1))) {
        way = way + ways(s, d, i - 1, count);
      }
    }

    memo[index] = way;
    return way;
  }

  /*
  at place i ==> count(ways(j-1, S,D)) where s[j:i] is in the dictionary

   */
  private static int iterative(String s, Set<String> d) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    for (int i = 1; i <= s.length(); i++) {
      int count = 0;
      for (int j = i; j >= 1; j--) {
        if (d.contains(s.substring(j - 1, i))) {
          count = count + dp[j - 1];
        }
      }

      dp[i] = count;
    }

    return dp[s.length()];
  }
}
