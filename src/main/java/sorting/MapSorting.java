package sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorting {
  public static void main(String[] args) {
    Map<Integer, Integer> unsortMap = new HashMap<>();
    unsortMap.put(1, 10);
    unsortMap.put(3, 6);
    unsortMap.put(4, 6);
    unsortMap.put(5, 6);
    unsortMap.put(2, 6);

    System.out.println("Original...");
    System.out.println(unsortMap);

    // sort by keys, a,b,c..., and return a new LinkedHashMap
    // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
    Comparator<Map.Entry<Integer, Integer>> comparator = (e1, e2) -> {
      int valueResult = e2.getValue().compareTo(e1.getValue());
      if (valueResult != 0) {
        return valueResult;
      }

      return e1.getKey().compareTo(e2.getKey());
    };

    Map<Integer, Integer> result = unsortMap.entrySet().stream()
        .sorted(comparator)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
            (oldValue, newValue) -> oldValue, LinkedHashMap::new));


    System.out.println("Sorted...");
    System.out.println(result);
  }
}
