package TreeProblems;


public class KDistanceAway {
    public static void main(String[] args) {
        TreeNode root = TreeOps.createBigTree();
        traverseTree(root, 3, 2);
    }

    private static int traverseTree(TreeNode root, int target, int k) {
        if (root == null) {
            return -1;
        }

        if (root.val == target) {
            printKLevelsDown(root, k, null);
            return 1;
        }
        int lans = traverseTree(root.left, target, k);
        if (lans != -1) {
            printKLevelsDown(root, k - lans, root.left);
            return lans + 1;
        }
        int rans = traverseTree(root.right, target, k);
        if (rans != -1) {
            printKLevelsDown(root, k - rans, root.right);
            return rans + 1;
        }
        return -1;
    }


    private static void printKLevelsDown(TreeNode root, int k, TreeNode blocker) {
        if (root == null || root == blocker) {
            return;
        }

        if (k == 0) {
            System.out.print(root.val + " ");
        }
        printKLevelsDown(root.left, k - 1, blocker);
        printKLevelsDown(root.right, k - 1, blocker);
    }
}
