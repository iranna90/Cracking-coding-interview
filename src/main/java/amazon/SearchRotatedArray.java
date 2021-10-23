package amazon;

/*
Search for a given number in a sorted array, with unique elements,
that has been rotated by some arbitrary number. Return -1 if the number does not exist.
Assume that the array does not contain duplicates.

1,2,3,4,5,6 === original
4,5,6,1,2,3 === rotated

 */
public class SearchRotatedArray {

    public static void main(String[] args) {
        int[] input = {5, 6, 1, 2, 3, 4};
        System.out.println(findItem(input, 5, 0, input.length - 1));
        System.out.println(findItem(input, 6, 0, input.length - 1));
        System.out.println(findItem(input, 1, 0, input.length - 1));
        System.out.println(findItem(input, 2, 0, input.length - 1));
        System.out.println(findItem(input, 3, 0, input.length - 1));
        System.out.println(findItem(input, 4, 0, input.length - 1));
        System.out.println(findItem(input, 9, 0, input.length - 1));

        input = new int[]{1};
        System.out.println(findItem(input, 1, 0, 0));
    }

    private static int findItem(int[] input, int number, int start, int end) {

        if (input == null || input.length == 0) {
            return -1;
        }

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int item = input[mid];

        if (number == item) {
            return mid;
        }

        if (number > item) {
            if (input[end] >= number) {
                return findItem(input, number, mid + 1, end);
            } else {
                return findItem(input, number, start, mid - 1);
            }
        } else {
            if (input[start] <= number) {
                return findItem(input, number, start, mid - 1);
            } else {
                return findItem(input, number, mid + 1, end);
            }
        }
    }
}
