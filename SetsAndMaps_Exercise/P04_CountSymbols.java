package SetsAndMaps_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> mapOfLetters = new TreeMap<>();

        for (char letter:text.toCharArray()) {
            if (mapOfLetters.containsKey(letter)){
                int currentValue = mapOfLetters.get(letter);
                mapOfLetters.put(letter, currentValue+1);
            } else {
                mapOfLetters.put(letter,1);
            }
        }

        mapOfLetters.entrySet().forEach(element -> System.out.println(element.getKey() + ": " + element.getValue() + " time/s"));
    }
}
