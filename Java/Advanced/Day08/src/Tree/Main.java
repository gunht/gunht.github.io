package Tree;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n4.left = n2;
        n4.right = n6;

        n2.left = n1;
        n2.right = n3;

        n6.left = n5;
        n6.right = n7;


        List<Integer> list = preorderTraversal(n4);
        for (int item:
             list) {
            System.out.println(item);
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
