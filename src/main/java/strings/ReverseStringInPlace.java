package strings;

public class ReverseStringInPlace {
    public static void main(String[] args) {
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f'};
        reverse(input);
        System.out.println(input);

        input = new char[]{'a', 'b', 'c'};
        reverse(input);
        System.out.println(input);
    }

    private static void reverse(char[] input) {
        if (input == null || input.length < 2) {
            return;
        }

        int beginning = 0;
        int end = input.length - 1;

        while (beginning < end) {
            char temp = input[beginning];
            input[beginning] = input[end];
            input[end] = temp;
            beginning++;
            end--;
        }
    }
}
