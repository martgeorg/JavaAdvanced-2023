package SetsAndMaps_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P03_PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numOfElements = Integer.parseInt(scanner.nextLine());

        Set<String> setOfElements = new TreeSet<>();

        for (int i = 0; i < numOfElements; i++) {
            String[] currentElements = scanner.nextLine().split("\\s+");
            setOfElements.addAll(Arrays.asList(currentElements));
        }

      setOfElements.forEach(element -> System.out.print(element + " "));
    }
}
