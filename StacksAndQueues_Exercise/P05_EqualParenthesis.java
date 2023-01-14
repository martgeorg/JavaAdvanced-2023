package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_EqualParenthesis {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque <Character> OpenBracketsStack = new ArrayDeque<>();
        boolean areBalanced = false;

        String inputOfChars = scanner.nextLine();

        for (Character bracket: inputOfChars.toCharArray()) {

            if (bracket == '(' || bracket == '{' || bracket == '['){
                OpenBracketsStack.push(bracket);

            } else if (bracket == ')' || bracket == '}' || bracket ==']'){
                if (OpenBracketsStack.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = OpenBracketsStack.pop();

                if (lastOpenBracket == '(' && bracket == ')'){
                    areBalanced = true;
                } else if (lastOpenBracket == '[' && bracket == ']'){
                    areBalanced = true;
                } else if (lastOpenBracket == '{' && bracket == '}'){
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }

        if (areBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
