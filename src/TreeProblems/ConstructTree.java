package TreeProblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConstructTree {
    public static void main(String[] args) {
        int[] pre = {1, 7, 2, 6, 5, 11, 9, 10, 4};
        int[] in = {2, 7, 5, 6, 11, 1, 9, 4, 10};
        TreeNode root = constructTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        printLevelOrder(root);
    }

    private static TreeNode constructTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {

        if (ps > pe) {
            return null;
        }

        if (ps == pe) {
            return new TreeNode(pre[ps]);
        }

        TreeNode root = new TreeNode(pre[ps]);
        int idx = -1;

        for (int i = is; i <= ie; i++) {
            if (pre[ps] == in[i]) {
                idx = i;
                break;
            }
        }

        int preLeftStart = ps + 1;
        int preLeftEnd = ps + idx - is;
        int inLeftEnd = idx - 1;

        int inRightStart = idx + 1;

        root.left = constructTree(pre, preLeftStart, preLeftEnd, in, is, inLeftEnd);
        root.right = constructTree(pre, preLeftEnd + 1, pe, in, inRightStart, ie);

        return root;
    }


    // For Printing Purpose
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
