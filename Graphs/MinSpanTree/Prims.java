import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import java.util.Arrays;

public class Prims extends Graphs {

    // // Kruskal's algorithm
    // public static HashSet<Edge> PrimsAlg(Graph G, Vertices r) {
    // HashSet<Edge> A = new HashSet<>();

    // // Initialize vertices with parent set to null and key set to infinity
    // for (Vertices v : G.getVertices()) {
    // v.setParent(null);
    // v.setKey(Double.POSITIVE_INFINITY);
    // }
    // r.setKey(0);

    // PriorityQueue<Vertices> Q = new PriorityQueue<>(G.getVertices());

    // // printQueue(Q); Q: [B, A, C, ]

    // while (!Q.isEmpty()) {
    // Vertices u = Q.poll();
    // System.out.println("u: " + u.data);

    // for (Vertices v : G.getAdjacentVertices(u)) {
    // System.out.println(u.data + " " + v.data);
    // double weight = G.getWeight(u, v);
    // if (Q.contains(v) && weight < v.getKey()) {
    // v.setParent(u);
    // v.setKey(weight);
    // Q.remove(v);
    // Q.add(v);
    // // add edge to A
    // Edge edge = G.getEdge(u, v);
    // A.add(edge);
    // }

    // }

    // }

    // return A;
    // }
    public static HashSet<Edge> PrimsAlg(Graph G, Vertices r) {
        HashSet<Edge> A = new HashSet<>();

        // Initialize vertices with parent set to null and key set to infinity
        for (Vertices v : G.getVertices()) {
            v.setParent(null);
            v.setKey(Double.POSITIVE_INFINITY);
        }
        r.setKey(0);

        // Q = G.V
        // Set vertices = G.getVertices();

        PriorityQueue<Vertices> Q = new PriorityQueue<>(G.getVertices());

        while (!Q.isEmpty()) {
            Vertices u = Q.poll();
            // Set of edges incident to u
            Set<Edge> edges = G.sortEdges(u);
            for (Edge e : edges) {
                // get the adjacent vertex
                Vertices v = e.destination;
                if (Q.contains(v) && e.weight < v.getKey()) {
                    v.setParent(u);
                    v.setKey(e.weight);
                    Q.remove(v);
                    Q.add(v);

                    // add edge to A

                    Edge edge = G.getEdge(u, v);
                    A.add(edge);

                }

            }
        }

        return A;
    }

    public static void printQueue(PriorityQueue<Vertices> Q) {
        System.out.print("Q: [");
        for (Vertices v : Q) {
            System.out.print(v.getData() + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        // Create a graph
        Graphs g = new Graphs();

        // Create a graph
        Graph graph = g.new Graph();

        // Create vertices
        Vertices node1 = g.new Vertices("A");
        Vertices node2 = g.new Vertices("B");
        Vertices node3 = g.new Vertices("C");

        // Add vertices to graph
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        // Add weighted edges to graph
        // Simple graph
        graph.addWeightedEdge(node1, node2, 1);
        graph.addWeightedEdge(node1, node3, 1);
        graph.addWeightedEdge(node2, node3, 2);

        // Run Kruskal's algorithm
        HashSet<Edge> A = PrimsAlg(graph, node2);

        // Print the MST
        System.out.println("MST:");
        for (Edge e : A) {
            System.out.println(e.source.data + " -> " + e.destination.data + " (weight = " + e.weight + ")");
        }

    }

}
