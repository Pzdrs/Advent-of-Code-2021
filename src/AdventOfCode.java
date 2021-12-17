import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class AdventOfCode {
    public static void main(String[] args) {
        int gammaRate, epsilonRate;
        StringBuilder gamma = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            int mostCommonBit = getMostCommonBit(getAmounts(i));
            gamma.append(mostCommonBit);
        }
        gammaRate = Integer.parseInt(gamma.toString(), 2);

        StringBuilder epsilon = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            int leastCommonBit = getLeastCommonBit(getAmounts(i));
            epsilon.append(leastCommonBit);
        }
        epsilonRate = Integer.parseInt(epsilon.toString(), 2);

        System.out.println(epsilonRate * gammaRate);
    }

    public static int[] getAmounts(int n) {
        try {
            int ones = 0, zeros = 0;
            Scanner scanner = new Scanner(new FileReader("src/data.txt"));
            while (scanner.hasNextLine()) {
                int currentBit = Integer.parseInt(String.valueOf(scanner.nextLine().toCharArray()[n]));
                if (currentBit == 0) zeros++;
                else ones++;
            }
            return new int[]{zeros, ones};
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new int[]{-1, -1};
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
