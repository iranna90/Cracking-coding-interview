package strings;

import java.util.Arrays;

public class ZeroSetRowZero {
    public static void main(String[] args) {
        int[][] input = {
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1}
        };

        System.out.println(Arrays.deepToString(input));
        fill(input);
        System.out.println(Arrays.deepToString(input));
    }

    private static void fill(int[][] input) {

        // check which row has zero
        boolean[] zeroRows = new boolean[input.length];
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if (input[row][col] == 0) {
                    zeroRows[row] = true;
                    break;
                }
            }
        }

        for (int row=0; row < zeroRows.length; row++) {
            if (zeroRows[row]) {
                fillZerosToRow(input, row);
            }
        }
    }

    private static void fillZerosToRow(int[][] input, int row) {
        for (int col=0; col < input[0].length; col++) {
            input[row][col] = 0;
        }
    }

}
