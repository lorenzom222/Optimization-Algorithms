import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Dijkstra extends Graphs {

    public void Dijkstra(Graph G, int w, Node s) {
        G.init_single_source(G, s);
        HashSet<Node> S = new HashSet<Node>();
        PriorityQueue<Node> Q = new PriorityQueue<Node>();
        for (Node v : G.nodes) {
            Q.add(v);
        }
        while (!Q.isEmpty()) {
            Node u = Q.poll();
            S.add(u);
            for (Node v : u.adj) {
                G.Relax(u, v, w);
            }
        }

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

        Dijkstra d = new Dijkstra();
        d.Dijkstra(graph, 1, node1);
        System.out.println(node1.distance);
        System.out.println(node2.distance);
        System.out.println(node3.distance);

    }
}