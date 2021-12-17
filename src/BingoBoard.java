import java.util.regex.Pattern;

public class BingoBoard {
    private int[][] board;
    private boolean[][] marked;

    public BingoBoard(int[][] board) {
        this.board = board;
        this.marked = new boolean[5][5];
    }

    public void mark(int number) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == number) marked[i][j] = true;
            }
        }
    }

    public int sumOfUnmarked() {
        int sum = 0;
        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[i].length; j++) {
                if (!marked[i][j]) sum += board[i][j];
            }
        }
        return sum;
    }

    public boolean checkWin() {
        boolean rowCompleted;
        for (int i = 0; i < marked.length; i++) {
            rowCompleted = true;
            for (int j = 0; j < marked[i].length; j++) {
                if (!marked[i][j]) rowCompleted = false;
            }
            if (rowCompleted) return true;
        }

        boolean columnCompleted;
        for (int i = 0; i < marked.length; i++) {
            columnCompleted = true;
            for (int j = 0; j < marked.length; j++) {
                if (!marked[j][i]) columnCompleted = false;
            }
            if (columnCompleted) return true;
        }
        return false;
    }
}
