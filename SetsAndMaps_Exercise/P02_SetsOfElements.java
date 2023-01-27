package SetsAndMaps_Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_SetsOfElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int [] arraysOfSets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> finalSet = new LinkedHashSet<>();

        int firstSetLength = arraysOfSets[0];
        int secondSetLength = arraysOfSets[1];

        for (int i = 0; i < firstSetLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }
        for (int i = 0; i < secondSetLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

       /* for (int number: firstSet) {
            for (int secondNum: secondSet) {
                if (number == secondNum){
                    finalSet.add(number);
                }
            }
        }

        for (int num: finalSet) {
            System.out.print(num + " ");
        }*/

        firstSet.retainAll(secondSet);

        firstSet.forEach(number -> System.out.print(number+ " "));
    }
}
