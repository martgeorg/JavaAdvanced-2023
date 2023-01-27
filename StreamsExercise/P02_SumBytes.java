package StreamsExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P02_SumBytes {
    public static void main(String[] args) throws IOException {

        String pathToFile = "/Users/nmbana/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        long sum = 0;

        byte[] readAllBytes = Files.readAllBytes(Path.of(pathToFile));

        for (byte character: readAllBytes) {
            if (character != 13 && character != 10){
                sum +=character;
            }
        }

        System.out.println(sum);

    }
}
