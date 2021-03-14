package Tree;

public class Leetcode_700 {
    private TreeNode root;

    Leetcode_700() {

    }

    public void add(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
        } else {
            subAdd(root, newNode);
        }
    }

    private void subAdd(TreeNode curNode, TreeNode newNode) {
        if (newNode.val < curNode.val) {
            if (curNode.left == null) {
                curNode.left = newNode;
            } else {
                subAdd(curNode.left, newNode);
            }
        }
        if (newNode.val > curNode.val) {
            if (curNode.right == null) {
                curNode.right = newNode;
            } else {
                subAdd(curNode.right, newNode);
            }
        }
    }

    public TreeNode searchBST(TreeNode curNode, int val) {
        if (root == null) {
            return null;
        }
        if (curNode.val == val) {
            return curNode;
        }
        if (val > curNode.val) {
            return searchBST(curNode.right, val);
        }
        return searchBST(curNode.left, val);
    }
}
