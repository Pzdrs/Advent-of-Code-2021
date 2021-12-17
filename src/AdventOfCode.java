import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class AdventOfCode {
    public static void main(String[] args) {
        int[] data = getData();
        if (data != null) {
            int sumsIncrease = 0;
            int last = 0;
            for (int i = 0; i < data.length; i++) {
                try {
                    int[] window = new int[]{data[i], data[i + 1], data[i + 2]};
                    int sum = Arrays.stream(window).sum();
                    if (i == 0) {
                        last = sum;
                        continue;
                    }
                    if (sum > last) sumsIncrease++;
                    last = sum;
                } catch (ArrayIndexOutOfBoundsException exception) {
                    break;
                }
            }
            System.out.println(sumsIncrease);
        }
    }

    public static int[] getData() {
        try {
            return Files.lines(Path.of("src/data.txt")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
