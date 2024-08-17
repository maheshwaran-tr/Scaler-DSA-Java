package TreeProblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        printLevelOrder(root);
    }

    private static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int noOfRemovals = queue.size();
            for (int i = 0; i < noOfRemovals; i++) {
                TreeNode node = queue.remove();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
}
