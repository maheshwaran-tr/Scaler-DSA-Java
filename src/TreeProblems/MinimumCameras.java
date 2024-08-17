package TreeProblems;

/*
    Already covered = 0
    Camera needed = -1
    Camera installed = 1
 */

public class MinimumCameras {
    static int cameras = 0;

    public static void main(String[] args) {
        TreeNode root = TreeOps.createBigTree();
        System.out.println(minCameraCover(root));
    }

    static int minCameraCover(TreeNode root) {
        // Initialize the cameras count and start the recursive function
        cameras = 0;
        if (minCam(root) == -1) {
            cameras++;
        }
        return cameras;
    }

    private static int minCam(TreeNode root) {
        if (root == null) {
            return 1; // Null nodes are considered covered
        }

        int lans = minCam(root.left);  // Recursively cover the left subtree
        int rans = minCam(root.right); // Recursively cover the right subtree

        // If either the left or right child is not covered, place a camera here
        if (lans == -1 || rans == -1) {
            cameras++;
            return 0; // This node has a camera
        }

        // If either child has a camera, this node is covered
        if (lans == 0 || rans == 0) {
            return 1; // This node is covered without needing a camera
        }

        // If both children are covered but don't have a camera, this node is not covered
        return -1; // This node needs a camera from its parent
    }
}
