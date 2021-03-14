package java_04;

public class Main {
    public static void main(String[] args) {

    }

    public static int timMax(int[] a, int n) {
        if (n == 1) {
            return a[0];
        } else if (a[n - 1] < timMax(a, n - 1)) {
            return a[n - 1];
        } else {
            return timMax(a, n - 1);
        }
    }
}
