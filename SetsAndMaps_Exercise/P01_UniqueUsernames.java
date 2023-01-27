package SetsAndMaps_Exercise;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_UniqueUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nOfUsernames = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < nOfUsernames; i++) {
            String user = scanner.nextLine();
            usernames.add(user);
        }

        usernames.forEach(System.out::println);
    }
}
