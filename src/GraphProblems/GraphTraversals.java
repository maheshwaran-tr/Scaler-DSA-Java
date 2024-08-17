package GraphProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GraphTraversals {

    public static void main(String[] args) {

        ArrayList<Integer>[] graph = GraphOps.getGraph();

        boolean[] visited = new boolean[graph.length];

        System.out.print("BFS TRAVERSING : ");
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited);
            }
        }

        boolean[] visited2 = new boolean[graph.length];
        System.out.print("\nDFS TRAVERSING : ");
        for (int i = 0; i < graph.length; i++) {
            if (!visited2[i]) {
                dfs(graph, i, visited2);
            }
        }

    }


    public static void bfs(ArrayList<Integer>[] graph, int src, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        visited[src] = true;

        while (queue.size() != 0) {
            int removed = queue.remove();
            System.out.print(removed + " ");
            for (int neighbour : graph[removed]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void dfs(ArrayList<Integer>[] graph, int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + " ");
        for (int neighbour : graph[src]) {
            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }
}
