package SetsAndMaps_Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06_FixEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap <String, String> sortedEmails = new LinkedHashMap<>();

        String entries = scanner.nextLine();

        while (!entries.equals("stop")){
            String email = scanner.nextLine();

            if (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com")) {
            } else {
                sortedEmails.putIfAbsent(entries, email);
            }
            entries = scanner.nextLine();
        }

        sortedEmails.entrySet().forEach(el -> System.out.println(el.getKey() + " -> " + el.getValue()));
    }
}
