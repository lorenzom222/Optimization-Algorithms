package Topic.Graphs;

import java.util.LinkedList;

public class Graphs {

    // public void Graph(Graph G, Node s) {

    // }

    // Node is a unit of data storage
    class Node {
        // Data can be represented as an int, String, or whatever
        String data;
        int distance;
        Node pi;
        String color;
        // List that stores the neighbors of node in graph
        LinkedList<Node> adj;
        // Flag to see if we visited Node or not
        boolean visited;
        // Finish Time
        int ft;

        Node(String data) {
            // Construct Node when we create one
            this.data = data;
            this.distance = Integer.MAX_VALUE;
            // this.color = "White";
            // keep track of parent
            this.pi = null;
            // why null? because we haven't visited it yet
            // so we don't know who its parent is
            // how do we find out parent? by traversing
            // how do we traverse? by using a stack or queue
            this.visited = false;
            this.ft = 0;
            adj = new LinkedList<>();
        }

        // Method to add Neighbors from data
        void addAdjacent(Node n) {
            adj.add(n);
        }

        // Method to remove Neighbors from dat

        void removeAdjacent(Node n) {
            adj.remove(n);
        }

        // Method to get neighbors to create AdjencyList
        LinkedList<Node> getAdjacent() {
            return adj;
        }

        // Get parent
        Node getParent() {
            return pi;
        }

    }

    // A graph is a data structure that organizes units of storages (nodes)
    class Graph {
        // List of nodes in graph
        LinkedList<Node> nodes;

        Graph() {
            // Construct Graph when we create one
            nodes = new LinkedList<>();

        }

        // Method to add Nodes to graph
        void addNode(Node n) {
            nodes.add(n);
        }

        // Method to remove Nodes from graph
        void removeNode(Node n) {
            nodes.remove(n);
        }

        // Method to get Nodes to create Graph
        LinkedList<Node> getNodes() {
            return nodes;
        }

        // how do we traverse a graph? by using a stack or queue
        // how do we find out if a node is visited? by using a flag
        // how do we find out if a node is a neighbor? by using a list
        // how do we find out if a node is a parent? by using a list
        // how do we find out if a node is a child? by using a list
    }

    public static void main(String[] args) {

        Graphs g = new Graphs();

        // Create a graph
        Graph graph = g.new Graph();

        // Create nodes
        Node node1 = g.new Node("A");
        Node node2 = g.new Node("B");
        Node node3 = g.new Node("C");
        Node node4 = g.new Node("D");

        // Add nodes to graph
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);

        // Add neighbors to nodes
        node1.addAdjacent(node2);
        node1.addAdjacent(node2);
        node2.addAdjacent(node3);
        node2.addAdjacent(node3);
        node2.addAdjacent(node3);
        node2.addAdjacent(node3);

        node3.addAdjacent(node4);
        node3.addAdjacent(node4);

        // Print out graph
        for (Node n : graph.getNodes()) {
            System.out.print(n.data + " -> ");
            for (Node adj : n.getAdjacent()) {
                System.out.print(adj.data + " ");
            }
            System.out.println();
        }

    }

}