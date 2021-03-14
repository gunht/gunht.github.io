import java.util.HashSet;
import java.util.Set;

public class Tung_36 {
    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                        {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        System.out.println(isValidSudoku(board));;
    }

    public static boolean isRowValid(char[][] board, int iRow) {
        boolean[] isExist = new boolean[10];
        for (int j = 0; j < 9; j++) {
            if (board[iRow][j] != '.') {
                int k = board[iRow][j] - '0';
                if (isExist[k]) {
                    return false;
                }
                isExist[k] = true;
            }
        }
        return true;
    }

    public static boolean isColValid(char[][] board, int jCol) {
        boolean[] isExist = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][jCol] != '.') {
                int k = board[i][jCol] - '0';
                if (isExist[k]) {
                    return false;
                }
                isExist[k] = true;
            }
        }
        return true;
    }

    public static boolean isBoardValid(char[][] board, int iRow, int jCol) {
        boolean[] isExist = new boolean[10];
        for (int i = iRow; i < iRow + 3; i++) {
            for (int j = jCol; j < jCol + 3; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    if (isExist[k]) {
                        return false;
                    }
                    isExist[k] = true;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            if (!isRowValid(board, i)) {
                return false;
            }
            if (!isColValid(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                if (!isBoardValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
