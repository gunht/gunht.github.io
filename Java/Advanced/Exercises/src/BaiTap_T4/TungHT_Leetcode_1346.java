package BaiTap_T4;

public class TungHT_Leetcode_1346 {
    public static void main(String[] args) {
//        int[] arr = {10,2,5,3};
//        int[] arr = {7,1,14,11};
        int[] arr = {-2,0,10,-19,4,6,-8};
//        int[] arr = {0,0};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        int n = arr.length;
        boolean result = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] * 2 == arr[i] && i != j) {
                    result = true;
                }
            }
        }
        return result;
    }
}
