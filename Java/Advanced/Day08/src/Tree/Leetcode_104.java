package Tree;

import Tree.TreeNode;

public class Leetcode_104 {
    public static void main(String[] args) {
        TreeNode n9 = new TreeNode(9);
        TreeNode n3 = new TreeNode(3);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left = n9;
        n3.right = n20;

        n20.left = n15;
        n20.right = n7;

        System.out.println(maxDepth(n3));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeftDepth = 1 + maxDepth(root.left);
        int maxRightDepth = 1 + maxDepth(root.right);

        return Math.max(maxLeftDepth, maxRightDepth);
    }
}
