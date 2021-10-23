package amazon;

public class CombinationOfBraces {

    private static final String OPENING = "{";
    private static final String CLOSING = "}";

    public static void main(String[] args) {
        printCombination(1, 0, 0, "");
        System.out.println();
        printCombination(2, 0, 0, "");
        System.out.println();
        printCombination(3, 0, 0, "");
    }


    // 2
    // {{}}
    // {}{}

    // {
    // 2, 1, 0, {
    // 2, 1, 1, {}
    //         2,2,1, {}{
    // 2,2,2,,{}{}   2,3,1, {}{{
    private static void printCombination(int max, int openingCount, int closingCount, String result) {
        if (openingCount > max || closingCount > max) {
            return;
        }

        if (closingCount == max) {
            System.out.println(result);
            return;
        }

        if (openingCount != closingCount) {
            printCombination(max, openingCount, closingCount + 1, result + CLOSING);
        }

        printCombination(max, openingCount + 1, closingCount, result + OPENING);
    }
}
