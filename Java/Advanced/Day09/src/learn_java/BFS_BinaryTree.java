package learn_java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS_BinaryTree {
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

        BFS(n1);
    }

    public static void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();

        queue.add(root);
        set.add(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            System.out.print(curNode.val + " ");

            if (curNode.left != null && !set.contains(curNode.left)) {
                queue.add(curNode.left);
                set.add(curNode.left);
            }
            if (curNode.right != null && !set.contains(curNode.right)) {
                queue.add(curNode.right);
                set.add(curNode.right);
            }
        }
    }
}
