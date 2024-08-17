package TreeProblems;


public class KLevelsDown {
    public static void main(String[] args) {
        TreeNode root = TreeOps.createBigTree();
        traverseTree(root, 3, 2);
    }

    private static void traverseTree(TreeNode root, int target, int k) {
        if (root == null) {
            return;
        }

        if (root.val == target) {
            printKLevelsDown(root, k);
            return;
        }
        traverseTree(root.left, target, k);
        traverseTree(root.right, target, k);
    }

    private static void printKLevelsDown(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.val + " ");
        }
        printKLevelsDown(root.left, k - 1);
        printKLevelsDown(root.right, k - 1);
    }
}
