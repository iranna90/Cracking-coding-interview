package graphs;

import java.security.SecureRandom;
import java.util.Random;

import tree.Node;

public class RandomNodeInTree {
  public static void main(String[] args) {
    System.out.println(Math.log10(10) / Math.log10(2));
  }

  private static Node random(Node root) {

    return null;
  }


  private static class Tree {
    private TreeNode root;

    public TreeNode random() {
      Random random = new Random();
      int searchSize = random.nextInt(root.size);
      return null;
    }

    public void insert(int value) {
      TreeNode newNode = new TreeNode(value);
      if (root == null) {
        root = newNode;
        newNode.parent = root;
        return;
      }

      insertNode(root, newNode);
    }

    private void insertNode(TreeNode root, TreeNode newNode) {
      root.size++;
      if (newNode.data <= root.data) {
        if (root.left == null) {
          root.left = newNode;
          newNode.parent = root.left;
        } else {
          insertNode(root.left, newNode);
        }
      } else {
        if (root.right == null) {
          root.right = newNode;
          newNode.parent = root.right;
        } else {
          insertNode(root.right, newNode);
        }
      }
    }

    public TreeNode find(int data) {
      return getTreeNode(root, data);
    }

    private TreeNode getTreeNode(TreeNode root, final int data) {
      if (root == null) {
        return null;
      }

      if (root.data == data) {
        return root;
      }

      if (data <= root.data) {
        return getTreeNode(root.left, data);
      }

      return getTreeNode(root.right, data);
    }

    private TreeNode delete(int data) {
      TreeNode treeNode = getForDelete(root, data);
      if (treeNode == null) {
        return null;
      }

      // deleting this node
      return treeNode;
    }

    private TreeNode getForDelete(TreeNode root, int data) {
      if (root == null) {
        return null;
      }

      if (root.data == data) {
        return root;
      }

      root.size--;

      TreeNode left = getForDelete(root.left, data);
      if (left != null) {
        return left;
      }

      TreeNode right = getForDelete(root.right, data);
      if (right != null) {
        return right;
      }

      root.size++;
      return null;
    }
  }


  private static class TreeNode {
    private final int data;
    private int size;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    private TreeNode(final int data) {
      this.data = data;
      this.size = 1;
    }
  }
}
