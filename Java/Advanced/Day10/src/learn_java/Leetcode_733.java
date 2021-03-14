package learn_java;

import java.util.Arrays;

public class Leetcode_733 {
    public static void main(String[] args) {
        int[][] a = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        floodFill(a, 1, 1, 2);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    static boolean[][] isExists;
    static int nRow, nCol;

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) {
            return image;
        }

        if (sr > image.length && sc > image[0].length) {
            return image;
        }
        DFS(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    public static void DFS(int[][] image, int i, int j, int oldColor, int newColor) {
        nRow = image.length;
        nCol = image[0].length;

        if (i < 0 || i >= nRow || j < 0 || j >= nCol || image[i][j] == newColor) {
            return;
        }


        if (image[i][j] == oldColor) {
            image[i][j] = newColor;
            DFS(image, i + 1, j, oldColor, newColor);
            DFS(image, i - 1, j, oldColor, newColor);
            DFS(image, i, j + 1, oldColor, newColor);
            DFS(image, i, j - 1, oldColor, newColor);
        }
    }
}
