package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02_ReverseNumberWithAStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque <Integer> stack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }


        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }


}
