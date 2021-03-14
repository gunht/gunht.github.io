package learn_java;

import java.util.*;

public class Leetcode_429 {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.children = new ArrayList<>();
        n3.children = new ArrayList<>();
        n1.children.add(n3);
        n1.children.add(n2);
        n1.children.add(n4);

        n3.children.add(n5);
        n3.children.add(n6);

        System.out.println(levelOrder(n1));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(root);
        set.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Node curNode = queue.poll();
                level.add(curNode.val);
                if (curNode.children != null) {
                    for (Node child : curNode.children) {
                        if (child != null && !set.contains(child)) {
                            queue.add(child);
                            set.add(child);
                        }
                    }
                }
            }
            result.add(level);
        }

        return result;
    }
}
