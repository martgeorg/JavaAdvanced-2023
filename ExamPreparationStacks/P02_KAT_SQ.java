package ExamPreparationStacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02_KAT_SQ {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] licensePlatesArray = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] carsArray = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque <Integer> platesSequence = new ArrayDeque<>();
        ArrayDeque <Integer> carsSequence = new ArrayDeque<>();

        for (int i = 0; i < licensePlatesArray.length; i++) {
            platesSequence.offer(licensePlatesArray[i]);
        }
        for (int i = 0; i < carsArray.length; i++) {
            carsSequence.push(carsArray[i]);
        }

        int countOfCars = 0;
        int days = 0;
        while (!platesSequence.isEmpty() && !carsSequence.isEmpty()){
            days++;

            int currentPlates = platesSequence.poll();
            int currentCars = carsSequence.pop();

            if(currentPlates>currentCars*2){
                platesSequence.addLast(currentPlates- (currentCars*2));
                countOfCars += currentCars;
            } else if (currentPlates < currentCars*2){
                int carsLeft = currentCars - (currentPlates/2);
                carsSequence.addLast(carsLeft);
                countOfCars += (currentPlates/2);
            } else {
                countOfCars += currentCars;
            }
        }

        System.out.printf("%d cars were registered for %d days!%n", countOfCars, days);
        if (!platesSequence.isEmpty()){
            int sumOfPlatesLeft = 0;
            while (!platesSequence.isEmpty()){
                sumOfPlatesLeft += platesSequence.pop();
            }
            System.out.printf("%d license plates remain!%n", sumOfPlatesLeft);
        } else if (!carsSequence.isEmpty()){
            int sumOfCarsLeft = 0;
            while (!carsSequence.isEmpty()){
                sumOfCarsLeft += carsSequence.pop();
            }
            System.out.printf("%d cars remain without license plates!%n", sumOfCarsLeft);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

    }
}
