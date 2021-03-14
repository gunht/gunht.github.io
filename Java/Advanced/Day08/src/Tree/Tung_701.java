package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tung_701 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        root.left = n2;
        root.right = n7;

        n2.left = n1;
        n2.right = n3;

        insertIntoBST(root, 5);

        List<Integer> list = preorderTraversal(root);
        for (int item:
                list) {
            System.out.println(item);
        }
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
        } else {
            subAdd(root, newNode);
        }
        return root;
    }

    private static void subAdd(TreeNode curNode, TreeNode newNode) {
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

    public static void print(TreeNode curNode) {
        // Pre-oder (truoc)
        // In-oder (giua)
        //Post-oder (sau)
        /*
        Pre-oder : Node -> L -> R: 4 -> 2 -> 1 -> 3 -> 6 -> 5 -> 7
        In-oder: L -> Node -> R: 1 -> 2 -> 3 -> 4 -> 5 -> 6-> 7
        Post-oder: L -> R -> Node: 1 -> 3 -> 2 -> 5 -> 7 -> 6-> 4
         */
        if (curNode == null) {
            return;
        }

        System.out.println(curNode.val);
        print(curNode.left);
        print(curNode.right);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal2(root, result);
        return result;
    }

    public static List<Integer> preorderTraversal2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }

        result.add(root.val);
        preorderTraversal2(root.left, result);
        preorderTraversal2(root.right, result);
        return result;
    }
}
