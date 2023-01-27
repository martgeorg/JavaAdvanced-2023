package SetsAndMaps_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P05_Phonebook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new TreeMap<>();
        String numbers = scanner.nextLine();

        while (!numbers.equals("search")){
            String[] users = numbers.split("-");
            String user = users[0];
            String number = users[1];

           phoneBook.putIfAbsent(user,number);

           numbers = scanner.nextLine();
        }

        String searchUser = scanner.nextLine();
        while (!searchUser.equals("stop")){
            if (phoneBook.containsKey(searchUser)){
                System.out.println(searchUser + " -> " + phoneBook.get(searchUser));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchUser);
            }
            searchUser = scanner.nextLine();
        }
    }
}
