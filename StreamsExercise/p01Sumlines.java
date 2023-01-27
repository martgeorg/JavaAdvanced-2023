package StreamsExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class p01Sumlines {
    public static void main(String[] args) throws IOException {
        String path = "/Users/nmbana/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        allLines.forEach(line -> {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        });

    }




}
