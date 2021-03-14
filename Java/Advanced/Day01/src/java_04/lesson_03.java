package java_04;

public class lesson_03 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {5, 4, 3, 2, 1};
        System.out.println(sum(a, 9, 9));
    }

    public static int sum(int[] a, int startIndex, int endIndex) {
        if (startIndex < 0 || startIndex > endIndex || endIndex > a.length
                || (startIndex == endIndex && endIndex >= a.length)) {
            return 0;
        } else {
            return a[startIndex] + sum(a, startIndex + 1, endIndex);
        }
    }
}
