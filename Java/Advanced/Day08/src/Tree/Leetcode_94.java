package Tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_94 {
    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        subInorderTraversal(root, result);
        return result;
    }

    public static List<Integer> subInorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }

        subInorderTraversal(root.left, result);
        result.add(root.val);
        subInorderTraversal(root.right, result);
        return result;
    }
}
