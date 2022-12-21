import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /*
    write a program to print words in sorted order (highest to lowest) of their
    repetitions in case of same repetitions order lexicographically or Alphabetical order
    input - [“one”, “one”,
     “two”, “two”, “three”, “four”, “four”, “five”, “six”, “six”, “one”, “two”,
      “three”, “four”, “five”, “six”, “ten”, “one”, “three”]
    output - [“one”, “four”, “six”, “three”, “two”, “five”, “ten”]
     */
    public static void main(String[] args) {

        System.out.println("Hello world!");
        printInSortedOrder(new String[]{"one", "one",
                "two", "two", "three", "four", "four", "five", "six", "six", "one", "two",
                "three", "four", "five", "six", "ten", "one", "three"});
    }

    // one -> 4
    // two ->
    public static void printInSortedOrder(String[] strings){
        Map<String, Integer> reptinsMap = new TreeMap<>();
        for(String word : strings){
            reptinsMap.put(word, reptinsMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(reptinsMap);
        List<String> sortedVals = reptinsMap.entrySet().stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(sortedVals);

    }
}