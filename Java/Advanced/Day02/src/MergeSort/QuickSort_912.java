package MergeSort;

import java.util.Arrays;

public class QuickSort_912 {
    public static void main(String[] args) {
        int[] a = {5,1,1,2,0,0};
//        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(sortArray(a)));
    }

    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] a, int L, int R) {
        if (L >= R) {
            return;
        }
        int key = a[(L + R)/2];
        int k = partition(a, L, R, key);

        quickSort(a, L, k - 1);
        quickSort(a, k, R);
    }

    public static int partition(int[] a, int L, int R, int key) {
        int iL = L, iR = R;
        while (iL <= iR) {
            while (a[iL] < key) {
                iL++;
            }
            while (a[iR] > key) {
                iR--;
            }
            if (iL <= iR) {
                int temp = a[iL];
                a[iL] = a[iR];
                a[iR] = temp;
                iL++; iR--;
            }
        }
        return iL;
    }
}
