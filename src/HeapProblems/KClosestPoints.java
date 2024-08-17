package HeapProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] result = kClosest(points, k);

        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }

    static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] + p1[1] * p1[1]);

        int[][] ans = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove();
        }
        return ans;
    }
}