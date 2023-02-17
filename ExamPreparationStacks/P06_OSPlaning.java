package ExamPreparationStacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P06_OSPlaning {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] taskArray = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] threadArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int seekNumber = Integer.parseInt(scanner.nextLine());
        int killer = 0;

        ArrayDeque<Integer> task = new ArrayDeque<>();
        ArrayDeque<Integer> thread = new ArrayDeque<>();

        for (int i = 0; i < taskArray.length; i++) {
            task.push(taskArray[i]);
        }
        for (int i = 0; i < threadArray.length; i++) {
            thread.offer(threadArray[i]);
        }

        while (!task.isEmpty() && !thread.isEmpty()){

            int currentTask = task.peek();
            int currentThread = thread.peek();

            if(currentTask==seekNumber){
                killer = currentThread;
                break;
            }


            if (currentThread>=currentTask){
                task.pop();
                thread.poll();
            } else {
                thread.poll();
            }


        }

        System.out.printf("Thread with value %d killed task %d%n", killer, seekNumber);
        System.out.println(thread.toString().replaceAll("[\\[\\,\\]]", ""));


    }
}
