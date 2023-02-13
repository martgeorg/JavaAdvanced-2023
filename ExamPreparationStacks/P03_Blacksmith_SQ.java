package ExamPreparationStacks;

import java.util.*;
import java.util.stream.Collectors;

public class P03_Blacksmith_SQ {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] steelArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] carbonArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> steelSequence = new ArrayDeque<>();
        ArrayDeque<Integer> carbonSequence = new ArrayDeque<>();

        for (int i = 0; i < steelArray.length; i++) {
            steelSequence.offer(steelArray[i]);
        }
        for (int i = 0; i < carbonArray.length; i++) {
            carbonSequence.push(carbonArray[i]);
        }

        Map<String,Integer> forgedSwords = new TreeMap<>();

        int numberOfForged = 0;
        while (!carbonSequence.isEmpty() && !steelSequence.isEmpty()){
            int currentSteel = steelSequence.poll();
            int currentCarbon = carbonSequence.pop();

            int mixedPower = currentCarbon+currentSteel;

            if (mixedPower == getSwordResource("Katana") || mixedPower == getSwordResource("Gladius")
            || mixedPower == getSwordResource("Shamshir") || mixedPower == getSwordResource("Sabre")){
                numberOfForged++;



                if (forgedSwords.containsKey(getSword(mixedPower))){
                    int currentCount = forgedSwords.get(getSword(mixedPower));
                    forgedSwords.put(getSword(mixedPower), currentCount+1);
                }else {
                    forgedSwords.putIfAbsent(getSword(mixedPower), 1);
                }



            } else {
                carbonSequence.push(currentCarbon + 5);
            }
        }

        if (numberOfForged > 0) {
            System.out.printf("You have forged %d swords.%n", numberOfForged);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelSequence.isEmpty()){
            System.out.println("Steel left: none");
        } else {
            List<String> collect = steelSequence.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println("Steel left: " + String.join(", ",collect));
        }

        if (carbonSequence.isEmpty()){
            System.out.println("Carbon left: none");
        } else {
            List<String> collect = carbonSequence.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println("Carbon left: " + String.join(", ",collect));
        }

        forgedSwords.entrySet().forEach(el -> System.out.printf("%s: %d%n", el.getKey(), el.getValue()));
    }

    public static int getSwordResource (String sword){
        switch (sword){
            case "Gladius":
                return 70;
            case "Shamshir":
                return 80;
            case "Katana":
                return 90;
            case "Sabre":
                return 110;
        }
        return Integer.parseInt(null);
    }

    public static String getSword (int sword){
        switch (sword){
            case 70:
                return "Gladius";
            case 80:
                return "Shamshir";
            case 90:
                return "Katana";
            case 110:
                return "Sabre";
        }
        return null;
    }
}
