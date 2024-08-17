package TreeProblems;

public class TreeOps {

    // Inorder Traversal: Left, Root, Right
    public static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    // Preorder Traversal: Root, Left, Right
    public static void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    // Postorder Traversal: Left, Right, Root
    public static void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.val + " ");
    }


    public static TreeNode createBigTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);

        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        return root;
    }
}
