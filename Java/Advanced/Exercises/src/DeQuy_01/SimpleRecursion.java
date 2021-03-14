package DeQuy_01;

public class SimpleRecursion {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(find(9, a, 0));
    }

    public static int find(int x, int[] a, int i) {
        if (i < 0 || i >= a.length) {
            return -1;
        } else if (a[i] == x) {
            return i;
        } else {
            return find(x, a, i + 1);
        }
    }
}
