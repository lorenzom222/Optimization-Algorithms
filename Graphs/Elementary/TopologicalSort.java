
import java.util.Stack;

public class TopologicalSort extends Graphs {

    public static Stack<Node> TopSort(Graph G) {
        for (Node u : G.nodes) {
            u.visited = false;
        }

        // Initialize stack
        Stack<Node> stack = new Stack<Node>();
        for (Node u : G.nodes) {
            if (!u.visited) {
                DFS_Visit(G, u, stack);
            }

        }

        return stack;

    }

    public void TopSort_Visit(Graph G, Node u, Stack<Node> stack) {
        // And we flag as visited
        u.visited = true;
        // then add it to the stack
        stack.push(u); // add vs push? add is for queue, push is for stack
        // Now, for each neighbor (edge)
        for (Node v : u.adj) {
            // If it is unexplore we will visit it
            if (!v.visited) {
                // Parent of v is u
                // Now we visit v
                TopSort_Visit(G, v, time);

            }

        }
    }

    public static void main(String[] args) {
        // Make graph: For the given DAG with edges A -> B, B -> C, C -> D and A -> D

        // Make graph
        Graph G = new Graph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");

        a.addAdjacent(b);
        b.addAdjacent(c);
        c.addAdjacent(d);

        a.addAdjacent(d);

        G.addNode(a);
        G.addNode(b);
        G.addNode(c);
        G.addNode(d);

        Stack<Node> stack = TopSort(G);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().data);
        }

    }

}
