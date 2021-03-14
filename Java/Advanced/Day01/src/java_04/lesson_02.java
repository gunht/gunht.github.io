package java_04;

public class lesson_02 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {5, 4, 3, 2, 1};
        System.out.println(sum(b, 0));
    }

    public static int sum(int[] a, int i) {
        if (i <= 0 || i >= a.length) {
            return 0;
        } else {
            return a[i] + sum(a, i + 1);
        }
    }
}
