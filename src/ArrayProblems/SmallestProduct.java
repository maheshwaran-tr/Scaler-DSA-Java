package ArrayProblems;
public class SmallestProduct {
    public static void main(String[] args) {
        System.out.println(smallProd(81000));
    }

    static int smallProd(int n) {

        StringBuilder sb = new StringBuilder();

        for (int div = 9; div >= 2; div--) {
            while (n % div == 0) {
                n = n / div;
                sb.append(div);
            }
        }

        if (n != 1) {
            return -1;
        }
        return Integer.parseInt(sb.reverse().toString());
    }
}
