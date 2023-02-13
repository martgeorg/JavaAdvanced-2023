package ExamPreparationStacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_EnergyDrinksSQ {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque <Integer> caffeineDeque = new ArrayDeque<>();
        ArrayDeque <Integer> energyDrinksDeque= new ArrayDeque<>();

        int[] caffeineMg = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] energyDrinks = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < caffeineMg.length; i++) {
            caffeineDeque.push(caffeineMg[i]);
        }
        for (int i = 0; i < energyDrinks.length; i++) {
            energyDrinksDeque.offer(energyDrinks[i]);
        }

        //max caffeine allowed is 300mg
        //initially he starts with 0

        int currentCaffeineInBody = 0;
        int maximumCaffeineAvailable = 300;

        while (!caffeineDeque.isEmpty() && !energyDrinksDeque.isEmpty()){

            int currentMilligrams = caffeineDeque.peek();
            int currentEnergyDrink = energyDrinksDeque.peek();
            int currentCalculatedAmount = currentMilligrams * currentEnergyDrink;

            if (currentCalculatedAmount + currentCaffeineInBody <= maximumCaffeineAvailable){
                currentCaffeineInBody += currentCalculatedAmount;
                caffeineDeque.pop();
                energyDrinksDeque.poll();
            } else {
                caffeineDeque.pop();
                energyDrinksDeque.poll();
                energyDrinksDeque.offer(currentEnergyDrink);
                if (currentCaffeineInBody >= 30) {
                    currentCaffeineInBody -= 30;
                }
            }
        }

        if (!energyDrinksDeque.isEmpty()) {
            System.out.printf("Drinks left: %s%n", String.join(", ", Arrays.asList(energyDrinksDeque.toString().
                    substring(1, energyDrinksDeque.toString().length() - 1))));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %s mg caffeine.", currentCaffeineInBody);


    }
}
