
package Topic.Graphs;

import java.util.LinkedList;
import java.util.Queue;

class BFS extends Graphs {

    public void BFS(Graph G, Node s) {
        for (Node u : G.nodes) {
            // u.visited = false instead of u.color = "white"
            u.visited = false;
            u.distance = Integer.MAX_VALUE;
            u.pi = null;
        }

        // s.visited = true instead of s.color = "grey"
        s.visited = true;
        s.distance = 0;
        s.pi = null;
        // How does this queue work?
        // It's a FIFO queue, so we add to the end and remove from the front
        // What is this for?
        // It's for keeping track of the nodes we need to visit

        Queue<Node> queue = new LinkedList<>();
        // Here we are adding the source node to the queue
        queue.offer(s);
        while (!queue.isEmpty()) {
            // Here we are removing the first node in the queue
            Node u = queue.poll();// s is removed from the queue and is now u
            // Where is this node coming from?
            // It's coming from the source node we added to the queue

            // What is this for loop doing?
            // It's going through the neighbors of the node we removed from the queue
            // and adding them to the queue
            for (Node v : u.adj) {
                if (!v.visited) {
                    // v.visited = true instead of v.color = "grey"
                    v.visited = true;
                    // We add 1 bc it takes 1 step to get to v from u
                    v.distance = u.distance + 1;
                    // u become v's parent bc we are traveling from u to v
                    v.pi = u;
                    // get parent of v with getParent(v);
                    queue.offer(v);

                }

            }
            // u.color = "black";
            u.visited = true;

            // Then we go back to the top of the while loop and remove the next node
            // in the queue and repeat the process until the queue is empty
            // and we are done with BFS traversal of the graph G from source node s
        }

    }

    // MEthod to print the path from source node s to node v
    public void shortestPath(Graph G, Node s, Node v) {
        if (v == s) {
            System.out.println(s.data);
            // down arrow
            System.out.println("\u2193");

        } else if (v.pi == null) {
            System.out.println("No path from " + s.data + " to " + v.data + " exists");
        } else {
            shortestPath(G, s, v.pi);
            System.out.println(v.data);
            System.out.println("\u2193");

        }
    }

    // // Method print the tree of the graph G from source node s
    // public void printTree(Graph G, Node s) {
    // for (Node u : G.nodes) {
    // if (u != s) {
    // System.out.println(u.pi.data + " -> " + u.data);
    // }
    // }
    // }

    public void printTree(Graph G) {

        for (Node u : G.nodes) {
            if (u.adj.size() == 0) {
                // System.out.print("Leaf " + u.data + " ");
                System.out.print(u.data + " ");

                printTree(G, u);
            }

        }

    }

    public void printTree(Graph G, Node v) {
        if (v.pi != null) {
            v = v.pi;

            System.out.print("\u2190 " + v.data + " ");

            printTree(G, v);

        } else {
            // System.out.println("Root");
            System.out.println(" ");

        }

    }

    // Handles matrix representation of graph

    public void BFS_AdjacencyMatrix(int[][] matrix, int s) {
        // Matrix looks like this
        // 0 1 1 0 0
        // 1 0 0 1 0
        // 1 0 0 0 1
        // 0 1 0 0 0
        // 0 0 1 0 0

        boolean[] visited = new boolean[matrix.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            // Here we are removing the first node in the queue
            int u = queue.poll();

            for (int v = 0; v < matrix.length; v++) {
                if (matrix[u][v] == 1) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        // What is the time complexity of BFS?
        // O(V + E)
        // V = number of vertices
        // E = number of edges

        BFS bfs = new BFS();
        Graph G = bfs.new Graph();

        Node a = bfs.new Node("A");
        Node b = bfs.new Node("B");
        Node c = bfs.new Node("C");
        Node d = bfs.new Node("D");
        Node e = bfs.new Node("E");

        a.addAdjacent(b);
        a.addAdjacent(c);
        b.addAdjacent(d);
        c.addAdjacent(e);

        G.addNode(a);
        G.addNode(b);
        G.addNode(c);
        G.addNode(d);
        G.addNode(e);

        // MAke a more complex graph
        Node f = bfs.new Node("F");
        Node g = bfs.new Node("G");
        Node h = bfs.new Node("H");
        Node i = bfs.new Node("I");
        Node j = bfs.new Node("J");
        Node k = bfs.new Node("K");
        Node l = bfs.new Node("L");
        Node m = bfs.new Node("M");

        a.addAdjacent(g);
        b.addAdjacent(f);
        b.addAdjacent(i);
        c.addAdjacent(j);
        c.addAdjacent(k);

        d.addAdjacent(l);
        d.addAdjacent(m);
        e.addAdjacent(l);
        e.addAdjacent(m);

        G.addNode(f);
        G.addNode(g);
        G.addNode(h);
        G.addNode(i);
        G.addNode(j);
        G.addNode(k);
        G.addNode(l);
        G.addNode(m);

        for (Node n : G.getNodes()) {
            System.out.print(n.data + " -> ");
            for (Node adj : n.getAdjacent()) {
                System.out.print(adj.data + " ");
            }
            System.out.println();
        }

        bfs.BFS(G, a);
        // from BFS, get the parent of each node
        // then print the path from the source node to each node

        // print distance from source node a to all other nodes
        for (Node n : G.getNodes()) {
            System.out.println("Distance from " + a.data + " to " + n.data + " is " + n.distance);
        }

        // print path from source node a to node e
        bfs.shortestPath(G, a, f);

        // print tree of graph G from source node a
        bfs.printTree(G);

        // BFS with Adjacency Matrix

        int[] row1 = { 0, 1, 1, 0, 0 };
        int[] row2 = { 1, 0, 0, 1, 0 };
        int[] row3 = { 1, 0, 0, 0, 1 };
        int[] row4 = { 0, 1, 0, 0, 0 };
        int[] row5 = { 0, 0, 1, 0, 0 };

        int[][] matrix = { row1, row2, row3, row4, row5 };

        bfs.BFS_AdjacencyMatrix(matrix, 0);

        // print result of BFS with Adjacency Matrix

    }
}