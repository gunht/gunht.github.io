package learn_java;

public class Leetcode_1346 {
    public static void main(String[] args) {
        int[] a = {7,14};
        System.out.println(checkIfExist(a));
    }

    public static boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] * 2 == arr[j] || arr[j] * 2 == arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
