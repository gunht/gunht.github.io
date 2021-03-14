package learn_java;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode(int value) {
        this.val = value;
        neighbors = new ArrayList<>();
    }
}
