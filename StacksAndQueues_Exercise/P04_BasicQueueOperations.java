package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04_BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();


        for (int elementToPush = 1; elementToPush <= n; elementToPush++) {
            stack.offer(scanner.nextInt());
        }

        for (int elementToRemove = 1; elementToRemove <= s ; elementToRemove++) {
            stack.poll();
        }

        if (stack.isEmpty()){
            System.out.println(0);
        } else if (stack.contains(x)){
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
