package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03_MaximumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque <Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String[] commandLine = scanner.nextLine().split("\\s++");
            String command = commandLine[0];

            switch (command){
                case "1":
                    stack.push(Integer.valueOf(commandLine[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }

        }
    }
}
