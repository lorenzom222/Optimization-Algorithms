import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Bellmam_Ford extends Graphs {

    public boolean Bellmam_Ford(Graph G, int w, Node s) {
        G.init_single_source(G, s);
        for (int i = 0; i < G.nodes.size() - 1; i++) {
            for (Node u : G.nodes) {// Edge start from u
                for (Node v : u.adj) {// Edge out of u
                    G.Relax(u, v, w); // Relax edge (u,v)
                }
            }
        }
        for (Node u : G.nodes) { // Edge start from u
            for (Node v : u.adj) { // Edge out of u
                if (v.distance > u.distance + w) { // Check if there is a negative
                                                   // cycle
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Graphs g = new Graphs();
        Graph graph = g.new Graph();
        Node node1 = g.new Node("A");
        Node node2 = g.new Node("B");
        Node node3 = g.new Node("C");

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        node1.addAdjacent(node2);
        node1.addAdjacent(node3);
        node2.addAdjacent(node3);

        node1.distance = 0;
        node2.distance = 1;
        node3.distance = 2;

        Bellmam_Ford bf = new Bellmam_Ford();
        bf.Bellmam_Ford(graph, 1, node1);
        System.out.println(node1.distance);
        System.out.println(node2.distance);
        System.out.println(node3.distance);

    }
}