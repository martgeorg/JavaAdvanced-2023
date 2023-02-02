package ObjectsAndClasses.P_01OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countOfPeople = Integer.parseInt(scanner.nextLine());
        Map <String,Integer> peopleMap = new TreeMap<>();

        for (int i = 1; i <=countOfPeople ; i++) {
            String[] dataForPeople = scanner.nextLine().split("\\s+");
            String name = dataForPeople[0];
            int age = Integer.parseInt(dataForPeople[1]);
            Person person = new Person(name,age);

            if (age > 30){
                peopleMap.putIfAbsent(person.getName(), person.getAge());
            }
        }


        for (Map.Entry<String, Integer> entry : peopleMap.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
