package learn_java;

import java.util.*;

public class DFS_BinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n4;

        n2.left = n3;
        n2.right = n5;

        n4.right = n6;

        DFS2(n1);
    }

    public static void DFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();

        stack.add(root);
        set.add(root);

        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            System.out.print(curNode.val + " ");

            if (curNode.right != null && !set.contains(curNode.right)) {
                stack.add(curNode.right);
                set.add(curNode.right);
            }

            if (curNode.left != null && !set.contains(curNode.left)) {
                stack.add(curNode.left);
                set.add(curNode.left);
            }

        }
    }

    public static void DFS2(TreeNode curNode) {
        if(curNode == null){
            return ;
        }

        // cong thuc
        System.out.print(curNode.val + " ");
        DFS2(curNode.left);
        DFS2(curNode.right);

    }
}
