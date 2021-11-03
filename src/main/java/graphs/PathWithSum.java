package graphs;

import tree.Node;

/*
count path having given sum,
the path can start anywhere and end anywhere
 */
public class PathWithSum {


  /*\
  We will find the sum not just from
   */
  private static int pathWithNode(Node root, int targetSum) {
    if (root == null) {
      return 0;
    }

    int pathStartingRoot = pathsWithSum(root, targetSum);


    int pathStartingLeft = pathsWithSum(root.left, targetSum);
    int pathStartingRight = pathsWithSum(root.right, targetSum);
    return pathStartingRoot + pathStartingLeft + pathStartingRight;
  }

  /*
  Find path of sum who have target sum
   */

  /*
  We can use dynamic programming to cache the result. as we are doing repeatative work
   */
  private static int pathsWithSum(Node root, int targetSum) {
    if (root == null) {
      return 0;
    }

    if (targetSum == 0) {
      return 1;
    }

    targetSum = targetSum - root.data;

    return pathsWithSum(root.left, targetSum) + pathsWithSum(root.right, targetSum);
  }
}
