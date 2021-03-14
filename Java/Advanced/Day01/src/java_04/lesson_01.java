package java_04;

public class lesson_01 {
    public static int find(int x, int[] a, int i) {
        // #1 your implementation
        if (i <= 0 || i >= a.length) {
            return -1;
        } else if (x == a[i]) {
            return i;
        } else {
            return find(x, a, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {5, 4, 3, 2, 1, 9, 8, 7, 6};
        // #2 Call function find
        System.out.println(find(8, b, 0));
    }

}
