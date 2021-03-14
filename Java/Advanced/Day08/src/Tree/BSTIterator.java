package Tree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        iterate(root);
    }

    public void iterate(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        iterate(curNode.right);
        stack.push(curNode);
        iterate(curNode.left);
    }
    /** @return the next smallest number */
    public int next() {
        return stack.pop().val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
