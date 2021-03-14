package learn_java;

public class Leetcode_941 {
    public static void main(String[] args) {
        int[] arr = {3,2};
        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (arr.length < 3) {
            return false;
        }
        if (arr.length == 3) {
            if (arr[0] < arr[1] && arr[1] > arr[2]) {
                return true;
            } else {
                return false;
            }
        }
        int pointer = n - 1;
        int peak = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                peak = i;
                break;
            }
            if (i + 1 == pointer || arr[i - 1] >= arr[i]) {
                return false;
            }
        }
        for (int i = peak; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
