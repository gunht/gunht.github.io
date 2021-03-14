package BaiTap_T5;

public class TungHT_Leetcode_941 {
    public static void main(String[] args) {
//        int[] a = {0,3,2,1};
//        int[] a = {0,1,2,4,2,1};
//        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int[] a = {};
        System.out.println(validMountainArray(a));
//        System.out.println(maxNumber(a));
    }

    public static boolean validMountainArray(int[] A) {
        if (A == null) {
            return false;
        }
        if (A.length < 3) {
            return false;
        }
        int peek = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peek = i;
                break;
            }
            if (A[i - 1] >= A[i] || i + 1 == A.length - 1) {
                return false;
            }
        }
        for (int i = peek; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
