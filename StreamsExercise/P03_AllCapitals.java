package StreamsExercise;

import java.io.*;

public class P03_AllCapitals {

    public static void main(String[] args) throws IOException {

        String pathToFile = "/Users/nmbana/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));


        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }

        writer.close();
    }
}
