package Tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
//        subPostorderTraversal(root, result);
        return result;
    }

//    public static List<Integer> subPostorderTraversal(TreeNode root, List<Integer> result) {
//        if (root == null) {
//            return result;
//        }
//
//        subPostorderTraversal(root.left, result);
//        result.add(root.val);
//        subPostorderTraversal(root.right, result);
//        return result;
//    }
}
