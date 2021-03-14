package DeQuy_03;

public class Sum2 {
    public static int sum2(int[] a, int startIndex, int endIndex) {
        if (startIndex < 0 ||
            startIndex > endIndex ||
            endIndex >= a.length && startIndex >= endIndex ||
            endIndex > a.length)
        {
            return 0;
        } else {
            return a[startIndex] + sum2(a, startIndex + 1, endIndex);
        }
        // #1 Your implementation
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // #2 call sum2
        System.out.println(sum2(a, 8, 9));
    }
}
