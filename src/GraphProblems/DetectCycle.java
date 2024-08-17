package GraphProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DetectCycle {
    public static void main(String[] args) {
        ArrayList<Integer>[] graph = GraphOps.getGraph();

        boolean[] visited = new boolean[graph.length];
        boolean cycleDetected = false;

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCyclicDFS(graph, i, visited,-1)) {
                    cycleDetected = true;
                    break;
                }
            }
        }

        System.out.println(cycleDetected);
    }


    private static boolean isCyclicDFS(ArrayList<Integer>[] graph, int src, boolean[] visited, int parent) {
        if (visited[src]) {
            return true;
        }

        visited[src] = true;

        for (int neighbour : graph[src]) {
            if (neighbour != -1 && neighbour != parent) {
                if (isCyclicDFS(graph, neighbour, visited, src)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCyclicBFS(ArrayList<Integer>[] graph, int src, boolean[] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{src, -1});
        visited[src] = true;

        while (q.size() > 0) {
            int[] a = q.remove();
            for (int n : graph[a[0]]) {
                if (n != a[1]) {
                    if (visited[n]) {
                        return true;
                    }
                    visited[n] = true;
                    q.add(new int[]{n, a[0]});
                }
            }
        }
        return false;
    }

}
