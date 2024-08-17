package HeapProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int val;
    int listInd;
    int dataInd;

    public Pair(int val, int listInd, int dataInd) {
        this.val = val;
        this.listInd = listInd;
        this.dataInd = dataInd;
    }

    @Override
    public int compareTo(Pair o) {
        return this.val - o.val;
    }
}

public class MergeKSortedLists {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(4);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(6);

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        List<Integer> result = MergeKSortedLists.mergeKLists(lists);
        System.out.println(result);
    }

    static List<Integer> mergeKLists(ArrayList<ArrayList<Integer>> lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Add all first indexes of lists
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(lists.get(i).get(0), i, 0));
        }

        List<Integer> ans = new ArrayList<>();


        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            ans.add(pair.val);

            if ((pair.dataInd + 1) < lists.get(pair.listInd).size()) {
                pq.add(new Pair(lists.get(pair.listInd).get(pair.dataInd + 1), pair.listInd, pair.dataInd + 1));
            }
        }

        return ans;
    }
}
