package StreamsExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class P05_LineNumbers {

    public static void main(String[] args) throws IOException {

        String path = "/Users/nmbana/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("output_line.txt");

        int lineNum = 1;

        for (String line : lines) {
            writer.println(lineNum + ". " + line);
            lineNum++;
        }
        writer.close();
    }
}
