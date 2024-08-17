package GraphProblems;

import java.util.ArrayList;

public class GraphOps {
    public static ArrayList<Integer>[] getGraph() {
        // Create a graph with 6 nodes (0 to 5)
        int numberOfNodes = 6;
        ArrayList<Integer>[] graph = new ArrayList[numberOfNodes];

        // Initialize the adjacency list for each node
        for (int i = 0; i < numberOfNodes; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 5);
//        addEdge(graph, 2, 1);     // add this for cyclic graph

        return graph;
    }

    public static void addEdge(ArrayList<Integer>[] graph, int u, int v) {
        graph[u].add(v); // Add v to u's list
        graph[v].add(u); // Add u to v's list (for undirected graph)
    }
}
