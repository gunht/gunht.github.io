package java_03;

public class leetcode_509 {
    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fib2(3));
    }

    public static int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N <= 2) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }
    static int[] F = new int[1000];
    public static int fib2(int N) {
        if (F[N] != 0) {
            return F[N];
        }
        if (N < 2) {
            F[0] = 0;
            F[1] = 1;
            return N;
        }
        F[N] = fib(N - 1) + fib(N - 2);
        return F[N];
    }
}
