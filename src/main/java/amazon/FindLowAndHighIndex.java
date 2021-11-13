package amazon;

public class FindLowAndHighIndex {
    public static void main(String[] args) {
        int[] input = {1, 1, 2, 2, 2, 3, 3, 3, 4};
        printHighAndLow(input, 1);
        printHighAndLow(input, 3);
        printHighAndLow(input, 4);
    }

    private static void printHighAndLow(int[] input, int number) {
        System.out.println(findLow(number, input, 0, input.length - 1));
        System.out.println(findHigh(number, input, 0, input.length - 1));
    }

    private static int findLow(int number, int[] input, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int item = input[mid];

        if (number == item && (mid == 0 || input[mid - 1] < item)) {
            return mid;
        }

        if (number <= item) {
            return findLow(number, input, start, mid - 1);
        }

        return findLow(number, input, mid + 1, end);
    }

    private static int findHigh(int number, int[] input, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int item = input[mid];

        if (number == item && ((mid == input.length - 1) || input[mid + 1] > item)) {
            return mid;
        }

        if (number < item) {
            return findHigh(number, input, start, mid - 1);
        }

        return findHigh(number, input, mid + 1, end);
    }
}
