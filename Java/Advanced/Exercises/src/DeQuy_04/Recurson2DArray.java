package DeQuy_04;

public class Recurson2DArray {
    public static void main(String[] args) {
        int[][] a = new int[1][1];
        travel(a, 0 , 0);
    }

    static void travel(int[][] a, int i, int j) {
        if (i < a.length) {
            if (j < a[i].length) {
                System.out.print("[" + i + ", " + j + "]");
                travel(a, i, j + 1);
            } else {
                travel(a, i + 1, 0);
            }
        }
    }
}
