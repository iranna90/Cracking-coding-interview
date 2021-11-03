package graphs;

import tree.Node;

public class CreateBTree {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8};
        Node node = buildTree(input, 0, input.length - 1);
        System.out.println(node);
        LevelPrint.print(node);
    }

    private static Node buildTree(int[] input, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(input[mid]);

        node.left = buildTree(input, start, mid - 1);
        node.right = buildTree(input, mid + 1, end);

        return node;
    }
}
