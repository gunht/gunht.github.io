package learn_java;

public class Tung_1672 {
    public static void main(String[] args) {
        int[][] a = {{2,8,7},{7,1,3},{1,9,5}};
        System.out.println(maximumWealth(a));
    }

    public static int maximumWealth(int[][] accounts) {
        int n = accounts.length;
        int result = 0;
        int[] a = new int[n];
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            a[i] = sum;
        }
        for (int i = 0; i < n; i++) {
            if (a[i] > result) {
                result = a[i];
            }
        }
        return result;
    }
}
