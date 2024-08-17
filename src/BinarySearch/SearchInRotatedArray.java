package BinarySearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        int[] a = { 9, 11, 14, 15, 20, 22, 25, 1, 3, 5, 7 };
        int tar = 7;

        int minIndex = findMin(a);
        int ans = binarySearch(a, 0, minIndex - 1, tar);
        if (ans == -1) {
            ans = binarySearch(a, minIndex, a.length - 1, tar);
        }
        System.out.println(ans);
        long et = System.currentTimeMillis();

        System.out.println("Executed in : " + (et - st));
    }

    private static int binarySearch(int[] a, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target)
                return mid;
            else if (a[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    private static int findMin(int[] a) {
        int left = 0, right = a.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] < a[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
