package learn_java;

public class Leetcode_200 {
    private static boolean[][] isExists;
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0',},
                {'1', '1', '0', '0', '0',},
                {'0', '0', '1', '0', '0',},
                {'0', '0', '0', '1', '1',},
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        int count = 0;
        isExists = new boolean[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (grid[i][j] == '1' && !isExists[i][j]) {
                    count++;
                    DFS(i, j, grid);
                }
            }
        }
        return count;
    }

    public static void DFS(int i, int j, char[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;

        if (i < 0 || i >= nRow || j < 0 || j >= nCol) {
            return;
        }

        if (isExists[i][j] || grid[i][j] == '0') {
            return;
        }

        isExists[i][j] = true;

        DFS(i - 1, j, grid);
        DFS(i + 1, j, grid);
        DFS(i, j + 1, grid);
        DFS(i, j - 1, grid);
    }
}
