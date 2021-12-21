import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {
    public static void main(String[] args) {
        List<Line> lines = getLines();
        int[][] map = new int[1000][1000];
        for (Line line : lines) {
            if (line.x1() == line.x2()) {
                for (int i = Math.min(line.y1(), line.y2()); i <= Math.max(line.y1(), line.y2()); i++) {
                    map[i][line.x1()] = map[i][line.x1()] + 1;
                }
            } else if (line.y1() == line.y2()) {
                for (int i = Math.min(line.x1(), line.x2()); i <= Math.max(line.x1(), line.x2()); i++) {
                    map[line.y1()][i] = map[line.y1()][i] + 1;
                }
            }
        }
        System.out.println(getOverlapAmount(map));
    }

    public static int getOverlapAmount(int[][] map) {
        int result = 0;
        for (int[] ints : map) {
            for (int anInt : ints) {
                if (anInt >= 2) result++;
            }
        }
        return result;
    }

    public static List<Line> getLines() {
        try {
            List<Line> lines = new ArrayList<>();
            Scanner scanner = new Scanner(new FileReader("src/data.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().replaceAll(" +", "");
                int[] coords = Arrays.stream(line.replaceAll("->", ",").split(",")).mapToInt(Integer::parseInt).toArray();
                lines.add(new Line(coords[0], coords[1], coords[2], coords[3]));
            }
            return lines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
