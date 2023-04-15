import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Graphs {

    public class Vertices implements Comparable<Vertices> {
        String data;
        Vertices parent;
        double key;

        Vertices(String data) {
            this.data = data;
            this.parent = null;
            this.key = Double.MAX_VALUE;

        }

        // Method to get neighbors to create AdjencyList
        String getData() {
            return data;
        }

        void setParent(Vertices pi) {
            this.parent = pi;
        }

        Vertices getParent() {
            return parent;
        }

        void setKey(double min) {
            this.key = min;
        }

        double getKey() {
            return key;
        }

        @Override
        public int compareTo(Vertices other) {
            return Double.compare(this.key, other.key);
        }

    }

    public class Edge {
        Vertices source;
        Vertices destination;
        double weight;

        Edge(Vertices source, Vertices destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        void setSource(Vertices source) {
            this.source = source;
        }

        void setDestination(Vertices destination) {
            this.destination = destination;
        }

        void setWeight(double weight) {
            this.weight = weight;
        }

        Vertices getSource() {
            return source;
        }

        Vertices getDestination() {
            return destination;
        }

        double getWeight() {
            return weight;
        }

    }

    class Graph {
        // List of vertices in graph
        Set<Vertices> vertices;
        Set<Edge> edges;
        HashMap<Vertices, HashSet<Vertices>> trees;

        Graph() {
            // Construct Graph when we create one
            vertices = new java.util.HashSet<>();
            edges = new java.util.HashSet<>();
            trees = new HashMap<>();

        }

        // Method to add vertices to graph
        void addNode(Vertices n) {
            vertices.add(n);
        }

        // Method to remove vertices from graph
        void removeNode(Vertices n) {
            vertices.remove(n);
        }

        // Method to get vertices to create Graph
        Set<Vertices> getVertices() {
            return vertices;
        }

        // Method to add weighted edge to the graph
        void addWeightedEdge(Vertices source, Vertices destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            edges.add(edge);
        }

        // Method to remove weighted edge from the graph
        void removeWeightedEdge(Vertices source, Vertices destination) {
            Edge edge = new Edge(source, destination, 0);
            edges.remove(edge);
        }

        // Sort edges by weight in order from least to greatest
        Set<Edge> sortEdges() {
            Set<Edge> sortedEdges = new TreeSet<>((e1, e2) -> {
                if (e1.weight != e2.weight) {
                    return Double.compare(e1.weight, e2.weight);
                }
                // If weights are equal, compare edges by hash code
                return Integer.compare(e1.hashCode(), e2.hashCode());
            });
            sortedEdges.addAll(edges);
            return sortedEdges;
        }

        Set<Edge> getEdges() {
            return edges;
        }

        public void setTree(HashMap<Vertices, HashSet<Vertices>> trees) {
            this.trees = trees;
        }

        void addTree(Vertices n, HashSet<Vertices> edges) {
            trees.put(n, edges);
        }

        HashSet<Vertices> getTree(Vertices n) {
            return trees.get(n);
        }

        // Get parent
        HashMap<Vertices, HashSet<Vertices>> getTrees() {
            return trees;
        }

        /// Print Tree and its edges
        String printTree(Vertices n) {
            String tree = "";
            HashSet<Vertices> edges = trees.get(n);
            tree += n.getData() + " -> ";
            for (Vertices v : edges) {
                tree += v.getData() + " ";
            }
            return tree;

        }

        // Get adjacent vertices to vertex n
        HashSet<Vertices> getAdjacentVertices(Vertices n) {
            HashSet<Vertices> adjacentVertices = new HashSet<>();
            for (Edge e : edges) {
                if (e.getSource().equals(n)) {
                    adjacentVertices.add(e.getDestination());
                }
                if (e.getDestination().equals(n)) {
                    adjacentVertices.add(e.getSource());
                }
            }
            return adjacentVertices;
        }

        // Get edges of vertex n
        HashSet<Edge> getEdges(Vertices n) {
            HashSet<Edge> adjacentEdges = new HashSet<>();
            for (Edge e : edges) {
                if (e.getSource().equals(n)) {
                    // must store edge as source to destination

                    adjacentEdges.add(e);

                }

                if (e.getDestination().equals(n)) {
                    // must store edge as destination to source
                    Edge edge = new Edge(e.getDestination(), e.getSource(), e.getWeight());
                    adjacentEdges.add(edge);
                }
            }
            return adjacentEdges;
        }

        // Get edge of vertex n and its neighbor
        Edge getEdge(Vertices n, Vertices neighbor) {
            Edge edge = null;
            for (Edge e : edges) {
                // System.out.println(e.getSource().data + " " + e.getDestination().data);
                // System.out.println(n.data + " " + neighbor.data);

                if (e.getSource().equals(n) && e.getDestination().equals(neighbor) || e.getSource().equals(neighbor)
                        && e.getDestination().equals(n)) {
                    edge = e;
                    return edge;

                }
            }
            return edge;
        }

        // Sort edges by weight in order from least to greatest for specific vertex
        Set<Edge> sortEdges(Vertices n) {
            Set<Edge> edges = getEdges(n);
            // sort edge set
            Set<Edge> sortedEdges = new TreeSet<>((e1, e2) -> {
                if (e1.weight != e2.weight) {
                    return Double.compare(e1.weight, e2.weight);
                }
                // If weights are equal, compare edges by hash code
                return Integer.compare(e1.hashCode(), e2.hashCode());
            });

            sortedEdges.addAll(edges);

            return sortedEdges;

        }

        // Method to get weight of edge for specific vertex and its neighbor
        double getWeight(Vertices n, Vertices neighbor) {
            double weight = 0;
            for (Edge e : edges) {
                if (e.getSource() == n && e.getDestination() == neighbor) {
                    weight = e.weight;
                }
            }
            return weight;
        }

    }

    public static void main(String[] args) {

        Graphs g = new Graphs();

        // Create a graph
        Graph graph = g.new Graph();

        // Create vertices
        Vertices node1 = g.new Vertices("A");
        Vertices node2 = g.new Vertices("B");
        Vertices node3 = g.new Vertices("C");
        Vertices node4 = g.new Vertices("D");

        // Add vertices to graph
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);

        // Add weighted edges to graph
        graph.addWeightedEdge(node1, node2, 5);
        graph.addWeightedEdge(node1, node3, 2);
        graph.addWeightedEdge(node2, node3, 9);
        graph.addWeightedEdge(node2, node4, 14);
        graph.addWeightedEdge(node3, node4, 5);

        // Print vertices of graph
        Set<Vertices> vertices = graph.getVertices();
        System.out.println("Vertices:");
        for (Vertices v : vertices) {
            System.out.println(v.data);
        }

        // Print edges of graph
        System.out.println("Edges:");
        for (Edge e : graph.edges) {
            System.out.println(e.source.data + " -> " + e.destination.data + " (weight = " + e.weight + ")");
        }

        // Sort edges by weight in descending order
        Set<Edge> sortedEdges = graph.sortEdges();
        System.out.println("Sorted edges:");
        for (Edge e : sortedEdges) {
            System.out.println(e.source.data + " -> " + e.destination.data + " (weight = " + e.weight + ")");
        }

    }

}
