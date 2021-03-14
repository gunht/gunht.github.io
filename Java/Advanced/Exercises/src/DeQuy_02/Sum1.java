package DeQuy_02;

public class Sum1 {
    public static int sum1(int[] a, int i) {
        if (i < 0 || i >= a.length) {
            return 0;
        } else {
            return a[i] + sum1(a, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {1, 2, 3};
        // #2 call function sum1
        System.out.println(sum1(b, 0));
    }
}
