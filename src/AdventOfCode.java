import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AdventOfCode {
    public static void main(String[] args) {
        List<String> numbers = getNumbers();
        if (numbers != null) {
            System.out.println(Integer.parseInt(filterOxygenGenerator(new ArrayList<>(numbers)), 2) *
                    Integer.parseInt(filterCO2Scrubber(new ArrayList<>(numbers)), 2));
        }
    }

    public static String filterOxygenGenerator(List<String> numbers) {
        int n = 0;
        while (numbers.size() > 1) {
            int[] amounts = getAmounts(numbers, n);
            Iterator<String> iterator = numbers.iterator();
            while (iterator.hasNext())
                if (iterator.next().substring(n, n + 1).equals(String.valueOf(amounts[0] == amounts[1] ? 0 : getLeastCommonBit(amounts))))
                    iterator.remove();
            n++;
        }
        return numbers.get(0);
    }

    public static String filterCO2Scrubber(List<String> numbers) {
        int n = 0;
        while (numbers.size() > 1) {
            int[] amounts = getAmounts(numbers, n);
            Iterator<String> iterator = numbers.iterator();
            while (iterator.hasNext())
                if (iterator.next().substring(n, n + 1).equals(String.valueOf(amounts[0] == amounts[1] ? 1 : getMostCommonBit(amounts))))
                    iterator.remove();
            n++;
        }
        return numbers.get(0);
    }

    public static List<String> getNumbers() {
        try {
            List<String> numbers = new ArrayList<>();
            Scanner scanner = new Scanner(new FileReader("src/data.txt"));
            while (scanner.hasNextLine()) {
                numbers.add(scanner.nextLine());
            }
            return numbers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int[] getAmounts(List<String> numbers, int n) {
        int ones = 0, zeros = 0;
        for (String number : numbers) {
            int currentBit = Integer.parseInt(String.valueOf(number.toCharArray()[n]));
            if (currentBit == 0) zeros++;
            else ones++;
        }
        return new int[]{zeros, ones};
    }

    public static int getMostCommonBit(int[] amounts) {
        if (amounts[0] > amounts[1]) return 0;
        else return 1;
    }

    public static int getLeastCommonBit(int[] amounts) {
        if (amounts[0] > amounts[1]) return 1;
        else return 0;
    }
}
