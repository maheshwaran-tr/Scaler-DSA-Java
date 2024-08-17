package BinarySearch;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,4,4,4,7,8};
        int element = 4;
        firstAndLastIndex(a, element);
    }

    static void firstAndLastIndex(int[] a, int target){
        int left = 0;
        int right = a.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = (left + right)/2;
            if(a[mid] == target){
                first = mid;
                right = mid - 1;
            }else if(a[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }


        left = 0;
        right = a.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = (left + right)/2;
            if(a[mid] == target){
                last = mid;
                left = mid + 1;
            }else if(a[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(first + " " + last);
    }
}
