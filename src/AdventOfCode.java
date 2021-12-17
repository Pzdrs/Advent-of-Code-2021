import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {
    public static void main(String[] args) {
        int[] randomNumbers = getRandomNumbers();
        List<BingoBoard> bingoBoards = loadBingoBoards();
        for (int randomNumber : randomNumbers) {
            for (BingoBoard bingoBoard : bingoBoards) {
                bingoBoard.mark(randomNumber);
                if (bingoBoard.checkWin()) {
                    System.out.println(bingoBoard.sumOfUnmarked() * randomNumber);
                    return;
                }
            }
        }
    }

    public static int[] getRandomNumbers() {
        try {
            Scanner scanner = new Scanner(new FileReader("src/data.txt"));
            return Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<BingoBoard> loadBingoBoards() {
        List<BingoBoard> bingoBoards = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader("src/data.txt"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty() && scanner.hasNextLine()) {
                    int[][] board = new int[5][5];
                    for (int i = 0; i < board.length; i++) {
                        String[] row = scanner.nextLine().trim().replaceAll(" +", " ").split(" ");
                        board[i] = Arrays.stream(row).mapToInt(Integer::parseInt).toArray();
                    }
                    bingoBoards.add(new BingoBoard(board));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bingoBoards;
    }
}
