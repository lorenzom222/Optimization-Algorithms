package Topic.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DFS extends Graphs {

    public void DFS(Graph G) {
        for (Node u : G.nodes) {
            u.visited = false;
            u.pi = null;
        }
        int time = -1;

        for (Node u : G.nodes) {
            if (u.visited == false) {
                DFS_Visit(G, u, time);
            }

        }

    }

    public void DFS_Visit(Graph G, Node u, int time) {
        // When you visit you take a step
        time = time + 1;
        // That is that time/distance it takes to get to u
        u.distance = time;
        // And we flag as visited
        u.visited = true;

        // Now, for each neighbor (edge)
        for (Node v : u.adj) {
            // If it is unexplore we will visit it
            if (v.visited == false) {
                // Parent of v is u
                v.pi = u;
                // Now we visit v
                DFS_Visit(G, v, time);

            }

        }

        time = time + 1;
        u.ft = time;
    }

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

    public static void main(String[] args) {
        // What is the time complexity of dfs?
        // O(V + E)
        // V = number of vertices
        // E = number of edges

        DFS dfs = new DFS();
        Graph G = dfs.new Graph();

        Node a = dfs.new Node("A");
        Node b = dfs.new Node("B");
        Node c = dfs.new Node("C");
        Node d = dfs.new Node("D");
        Node e = dfs.new Node("E");

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
        Node f = dfs.new Node("F");
        Node g = dfs.new Node("G");
        Node h = dfs.new Node("H");
        Node i = dfs.new Node("I");
        Node j = dfs.new Node("J");
        Node k = dfs.new Node("K");
        Node l = dfs.new Node("L");
        Node m = dfs.new Node("M");

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

        // for (Node n : G.getNodes()) {
        // System.out.print(n.data + " -> ");
        // for (Node adj : n.getAdjacent()) {
        // System.out.print(adj.data + " ");
        // }
        // System.out.println();
        // }

        dfs.DFS(G);
        // from dfs, get the parent of each node
        // then print the path from the source node to each node

        // print distance from source node a to all other nodes
        for (Node n : G.getNodes()) {
            System.out.println("Distance from " + a.data + " to " + n.data + " is " + n.distance);
        }
        // dfs.shortestPath(G, a, h);
        dfs.printTree(G);

    }

}
