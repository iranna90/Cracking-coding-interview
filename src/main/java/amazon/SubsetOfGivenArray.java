package amazon;

/*
Find all subsets of a given set of integers
We are given a set of integers and we have to find all the possible subsets of this set of integers. The following example elaborates on this further.

Given set of integers:

2
3
4
All possile subsets for the given set of integers:

2
3
2, 3
4
2, 4
3, 4
2, 3, 4
 */
public class SubsetOfGivenArray {

  public static void main(String[] args) {
    int[] input = {2, 3, 4};
    subset(input, 0, "");
  }

  private static void subset(int[] input, int index, String result) {
    if (index >= input.length) {
      System.out.println(result);
      return;
    }

    // this value
    int nextIndex = index + 1;
    subset(input, nextIndex, result);
    subset(input, nextIndex, result + "," + input[index]);
  }
}
