package HeapProblems;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder());  // To add with descending order.
        pq2 = new PriorityQueue<>();  // By default, it adds with ascending order.
    }

    void add(int num) {
        if (pq1.isEmpty() && pq2.isEmpty()) {
            pq1.add(num);
        } else {
            if (num < pq1.peek()) {
                pq1.add(num);
            } else {
                pq2.add(num);
            }
        }

        int diff = Math.abs(pq1.size() - pq2.size());
        if (diff > 1) {
            if (pq1.size() > pq2.size()) {
                pq2.add(pq1.remove());
            } else {
                pq1.add(pq2.remove());
            }
        }
    }

    int findMedian() {
        if (pq1.size() >= pq2.size()) {
            return pq1.peek();
        } else {
            return pq2.peek();
        }
    }

    int remove() {
        if (pq1.size() >= pq2.size()) {
            return pq1.remove();
        } else {
            return pq2.remove();
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.add(1);
        mf.add(2);
        mf.add(16);
        mf.add(3);
        System.out.println(mf.findMedian());
        mf.add(9);
        System.out.println(mf.findMedian());
        mf.add(6);
        mf.add(4);
        System.out.println(mf.remove());
        System.out.println(mf.findMedian());
    }
}
