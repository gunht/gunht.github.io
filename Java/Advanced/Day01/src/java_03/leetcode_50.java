package java_03;

public class leetcode_50 {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
    }

    public static double myPow(double x, int n) {//chua chinh xac - sai le`
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            n = -n;
            x = x * -0.5;
        }
        return x * myPow(x, n - 1);//chua chinh xac
    }
}
