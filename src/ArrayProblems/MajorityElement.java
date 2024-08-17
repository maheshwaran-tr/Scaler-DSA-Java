package ArrayProblems;
// Moor's Algorithm

public class MajorityElement {
    public static void main(String[] args) {
        int[] a = { 6, 5, 5 };
        System.out.println(majorityElement(a));
    }

    static int majorityElement(int[] nums) {
        int ck = nums[0];
        int c = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ck) {
                c = c + 1;
            } else {
                c = c - 1;
            }

            if (c == 0) {
                ck = nums[i];
                c = 1;
            }
        }
        System.out.println(ck);
        int count = 0;
        for (int n : nums) {
            if (n == ck)
                count++;
        }

        if (count > nums.length / 2)
            return ck;
        return -1;
    }
}
