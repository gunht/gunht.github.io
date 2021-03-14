package Tree;

public class Tung_112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4_1 = new TreeNode(4);
        TreeNode n13 = new TreeNode(13);
        TreeNode n1 = new TreeNode(1);

        root.left = n4;
        root.right = n8;

        n4.left = n11;

        n11.left = n7;
        n11.right = n2;

        n8.left = n13;
        n8.right = n4;

        n4.right = n1;

        System.out.println(hasPathSum(root, 18));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
