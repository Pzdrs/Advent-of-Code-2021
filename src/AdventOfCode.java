import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AdventOfCode {

    public static void main(String[] args) {
        Map<Integer, Long> fish = loadInitial();

        for (int i = 0; i < 256; i++) {
            for (int fishTimer = 0; fishTimer <= 8; fishTimer++)
                fish.put(fishTimer - 1, fish.getOrDefault(fishTimer, 0L));
            fish.put(6, fish.getOrDefault(6, 0L) + fish.get(-1));
            fish.put(8, fish.remove(-1));
        }
        long sum = 0;
        for (Long value : fish.values()) {
            sum += value;
        }
        System.out.println(sum);
    }

    public static Map<Integer, Long> loadInitial() {
        Map<Integer, Long> initial = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new FileReader("src/data.txt"));
            String[] fish = scanner.next().split(",");
            for (String s : fish) {
                initial.put(Integer.parseInt(s), initial.getOrDefault(Integer.parseInt(s), 0L) + 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return initial;
    }
}
