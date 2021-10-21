package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<String> result = new ArrayList<>();
        permutations(input, result, new ArrayList<>());
        System.out.println(result);
    }

    private static void permutations(int[] inputs, List<String> result, List<Integer> used) {
        if (used.size() == inputs.length) {
            result.add(used.stream().map(Object::toString)
                    .collect(Collectors.joining()));
            return;
        }

        for (Integer item : inputs) {
            if (!used.contains(item)) {
                used.add(item);
                permutations(inputs, result, used);
                used.remove(item);
            }
        }
    }
}
