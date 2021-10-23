package amazon;

/*
You are given a dictionary of words and a large input string.
You have to find out whether the input string can be completely segmented into the words of a given dictionary.
The following two examples elaborate on the problem further.
 */

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
Example: ["iranna", "pooja", "ir", "ira", "nna", "pooja"]
string: irapooja == true
string: poojairanna == true
string: poojairannank == false
 */
public class StringSegmentation {

    public static void main(String[] args) {
        String[] dictionary = {"iranna", "pooja", "ira", "ir", "na"};
        System.out.println(isSegment(Arrays.stream(dictionary).collect(Collectors.toSet()), "irapooja", "", 0));
        System.out.println(isSegment(Arrays.stream(dictionary).collect(Collectors.toSet()), "irannapooja", "", 0));
        System.out.println(isSegment(Arrays.stream(dictionary).collect(Collectors.toSet()), "irannapoojank", "", 0));
        System.out.println(isSegment(Arrays.stream(dictionary).collect(Collectors.toSet()), "irairirannapooja", "", 0));
        System.out.println(isSegment(Arrays.stream(dictionary).collect(Collectors.toSet()), "abcdefghijklmn", "", 0));
        System.out.println(isSegment(Arrays.stream(dictionary).collect(Collectors.toSet()), "irannapooja", "", 0));
    }

    private static boolean isSegment(Set<String> dictionary, String main, String sub, int index) {
        if (index >= main.length() && sub.isEmpty()) {
            return true;
        }

        if (index >= main.length()) {
            return false;
        }

        sub = sub + main.charAt(index);

        if (!dictionary.contains(sub)) {
            return isSegment(dictionary, main, sub, index + 1);
        }

        return isSegment(dictionary, main, sub, index + 1) || isSegment(dictionary, main, "", index + 1);
    }
}
