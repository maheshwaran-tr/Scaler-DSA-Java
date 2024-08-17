package TreeProblems;


import java.util.Stack;

public class ZigZagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        zigzag(root);
    }

    private static void zigzag(TreeNode root) {
        Stack<TreeNode> curr = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        curr.push(root);

        int level = 0;

        while (!curr.isEmpty()) {
            while (!curr.isEmpty()) {
                TreeNode node = curr.pop();
                System.out.print(node.val + " ");

                if (level % 2 == 0) {
                    if (node.left != null) next.push(node.left);
                    if (node.right != null) next.push(node.right);
                } else {
                    if (node.right != null) next.push(node.right);
                    if (node.left != null) next.push(node.left);
                }
            }
            System.out.println();
            level++;

            curr = next;
            next = new Stack<>();
        }
    }
}
