package ExamPreparationStacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P05_Meeting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] steelArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] carbonArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> male = new ArrayDeque<>();
        ArrayDeque<Integer> female = new ArrayDeque<>();

        for (int i = 0; i < steelArray.length; i++) {
            male.push(steelArray[i]);
        }
        for (int i = 0; i < carbonArray.length; i++) {
            female.offer(carbonArray[i]);
        }

//        String[] maleInfo = scanner.nextLine().split("\\s+");
//        ArrayDeque<Integer> male = new ArrayDeque<>();
//        for (String currMale : maleInfo) {
//            male.push(Integer.parseInt(currMale));
//        }
//
//        String[] femaleInfo = scanner.nextLine().split("\\s+");
//        ArrayDeque<Integer> female = new ArrayDeque<>();
//        for (String currFemale : femaleInfo) {
//            female.offer(Integer.parseInt(currFemale));
//        }

        int countOfMatches = 0;

        while (!male.isEmpty() && !female.isEmpty()){

            int currentFemale = female.poll();
            int currentMale = male.pop();


            if (currentMale<=0 || currentFemale<=0){
                if (currentMale<=0){
                    female.push(currentFemale);
                }
                if (currentFemale<=0){
                    male.push(currentMale);
                }
                continue;
            }

            if (currentMale%25==0){
                male.pop();
                if (male.isEmpty()){
                    female.push(currentFemale);
                    break;
                }
                female.push(currentFemale);
                continue;
            }

            if (currentFemale%25==0){
                female.poll();
                if (female.isEmpty()){
                    male.push(currentMale);
                    break;
                }
                male.push(currentMale);
                continue;
            }

            if(currentMale==currentFemale){
                countOfMatches++;
            } else {
                male.push(currentMale-2);
            }


        }

        System.out.printf("Matches: %d%n", countOfMatches);

        System.out.print("Males left: ");
        if (male.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(male.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.print("Females left: ");
        if (female.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(female.toString().replaceAll("[\\[\\]]", ""));
        }

    }
}
