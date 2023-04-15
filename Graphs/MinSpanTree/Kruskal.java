import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Kruskal extends Graphs {

    // public static HashSet KruskalAlg(Graph G) {

    // HashSet<Edge> A = new HashSet<>();

    // for (Vertices v : G.getVertices()) {
    // // Make a set (tree) for that v
    // HashSet<Vertices> tree = new HashSet<>();

    // // Add v to the set
    // tree.add(v);
    // G.addTree(v, tree);
    // }

    // for (Edge edge : G.sortEdges()) {
    // Vertices u = edge.source;
    // Vertices v = edge.destination;
    // HashSet<Vertices> treeU = G.getTree(u);
    // HashSet<Vertices> treeV = G.getTree(v);

    // System.out.println("u: " + u.data + " v: " + v.data);
    // System.out.println("treeU: " + G.printTree(u) + " treeV: " + G.printTree(v));

    // if (!treeU.contains(v) || !treeV.contains(u)) {
    // // A:= A ∪ {(u, v)} ∪ {(v, u)}
    // A.add(edge);
    // // UNION(FIND-SET(u), FIND-SET(v))
    // HashSet<Vertices> mergetree = new HashSet<>();
    // // Merge trees

    // mergetree.addAll(treeU);
    // mergetree.addAll(treeV);

    // // Print trees
    // System.out.println("Merged tree: " + G.printTree(u));
    // System.out.println("Merged tree: " + G.printTree(v));

    // for (Vertices vertex : mergetree) {
    // System.out.println("vertex: " + vertex.data);
    // G.addTree(vertex, mergetree);
    // }

    // }

    // }

    // return A;

    // }

    // Kruskal's algorithm
    public static HashSet<Edge> KruskalAlg(Graph G) {
        HashSet<Edge> A = new HashSet<>();
        DisjointSet disjointSet = new DisjointSet(G.getVertices());

        for (Edge edge : G.sortEdges()) {
            Vertices u = edge.source;
            Vertices v = edge.destination;
            Vertices rootU = disjointSet.find(u);
            Vertices rootV = disjointSet.find(v);

            if (rootU != rootV) {
                A.add(edge);
                disjointSet.union(u, v);
            }
        }

        return A;
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
        HashSet<Edge> A = KruskalAlg(graph);

        // Print the MST
        System.out.println("MST:");
        for (Edge e : A) {
            System.out.println(e.source.data + " -> " + e.destination.data + " (weight = " + e.weight + ")");
        }

    }

}

// Disjoint sets (Union-Find) class

class DisjointSet extends Graphs {
    private HashMap<Vertices, Vertices> parent;

    DisjointSet(Set<Vertices> vertices) {
        parent = new HashMap<>();
        for (Vertices v : vertices) {
            parent.put(v, v);
        }
    }

    Vertices find(Vertices v) {
        if (parent.get(v) == v) {
            return v;
        }
        Vertices root = find(parent.get(v));
        parent.put(v, root);
        return root;
    }

    void union(Vertices u, Vertices v) {
        Vertices rootU = find(u);
        Vertices rootV = find(v);
        parent.put(rootU, rootV);
    }
}
