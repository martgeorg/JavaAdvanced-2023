package ExamPreparationStacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04_FoodFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //sample of words we look for and where I will fill the found words
        String[] wordsArray = {"pear", "flour", "pork", "olive"};
        String [] hiddenArray = {"****", "*****", "****", "*****"};

        List<String> foundWords = new ArrayList<>();

        // reading the input from scanner as String array
        String[] vowelsStr = scanner.nextLine().split("\\s+");
        String[] consonantsStr = scanner.nextLine().split("\\s+");

        // Converting the String array into Char array
        String v = "";
        for (String n:vowelsStr)
            v+=n;
        char[] vowels = v.toCharArray();

        String c = "";
        for (String n:consonantsStr)
            c+=n;
        char[] consonants = c.toCharArray();

        //filling the deque
        ArrayDeque<Character> vowelsSequence = new ArrayDeque<>();
        ArrayDeque<Character> consonantsSequence = new ArrayDeque<>();

        for (int i = 0; i < vowels.length; i++) {
            vowelsSequence.offer(vowels[i]);
        }
        for (int i = 0; i < consonants.length; i++) {
            consonantsSequence.push(consonants[i]);
        }

        String firstWordToCheck = wordsArray[0];
        String secondWordToCheck = wordsArray[1];
        String thirdWordToCheck = wordsArray[2];
        String fourthWordToCheck = wordsArray[3];

        StringBuilder firstWordToFill= new StringBuilder(hiddenArray[0]);
        StringBuilder secondWordToFill= new StringBuilder(hiddenArray[0]);
        StringBuilder thirdWordToFill= new StringBuilder(hiddenArray[0]);
        StringBuilder fourthWordToFill= new StringBuilder(hiddenArray[0]);


        while (!consonantsSequence.isEmpty()){

            char currentVowel = vowelsSequence.poll();
            char currentConsonant = consonantsSequence.pop();

            //find if Vowels are present in any word
            FillVowels(hiddenArray, firstWordToCheck, secondWordToCheck, thirdWordToCheck, fourthWordToCheck, firstWordToFill, secondWordToFill, thirdWordToFill, fourthWordToFill, currentVowel);

            vowelsSequence.offer(currentVowel);

            //find if Consonants are present in any word
            FillConsonants(hiddenArray, firstWordToCheck, secondWordToCheck, thirdWordToCheck, fourthWordToCheck, firstWordToFill, secondWordToFill, thirdWordToFill, fourthWordToFill, currentConsonant);
        }

        FillListOfFoundWords(hiddenArray, foundWords);

        System.out.printf("Words found: %d%n", foundWords.size());
        foundWords.forEach(System.out::println);

    }

    private static void FillListOfFoundWords(String[] hiddenArray, List<String> foundWords) {
        String firstFoundWord = hiddenArray[0];
        String secondFoundWord = hiddenArray[1];
        String thirdFoundWord = hiddenArray[2];
        String fourthFoundWord = hiddenArray[3];

        if (!firstFoundWord.contains("*")){
            foundWords.add(firstFoundWord);
        }
        if (!secondFoundWord.contains("*")){
            foundWords.add(secondFoundWord);
        }
        if (!thirdFoundWord.contains("*")){
            foundWords.add(thirdFoundWord);
        }
        if (!fourthFoundWord.contains("*")){
            foundWords.add(fourthFoundWord);
        }
    }


    private static void FillConsonants(String[] hiddenArray, String firstWordToCheck, String secondWordToCheck, String thirdWordToCheck, String fourthWordToCheck, StringBuilder firstWordToFill, StringBuilder secondWordToFill, StringBuilder thirdWordToFill, StringBuilder fourthWordToFill, char currentConsonant) {
        for (int i = 0; i < firstWordToCheck.toCharArray().length; i++) {
            char[] currentChars = firstWordToCheck.toCharArray();
            char charToCheck = currentChars[i];
            if (charToCheck == currentConsonant){
                firstWordToFill.replace(i,i+1, String.valueOf(currentConsonant));
                hiddenArray[0] = firstWordToFill.toString();
            }

        }
        for (int i = 0; i < secondWordToCheck.toCharArray().length; i++) {
            char[] currentChars = secondWordToCheck.toCharArray();
            char charToCheck = currentChars[i];
            if (charToCheck == currentConsonant){
                secondWordToFill.replace(i,i+1, String.valueOf(currentConsonant));
                hiddenArray[1] = secondWordToFill.toString();
            }

        }
        for (int i = 0; i < thirdWordToCheck.toCharArray().length; i++) {
            char[] currentChars = thirdWordToCheck.toCharArray();
            char charToCheck = currentChars[i];
            if (charToCheck == currentConsonant){
                thirdWordToFill.replace(i,i+1, String.valueOf(currentConsonant));
                hiddenArray[2] = thirdWordToFill.toString();
            }

        }
        for (int i = 0; i < fourthWordToCheck.toCharArray().length; i++) {
            char[] currentChars = fourthWordToCheck.toCharArray();
            char charToCheck = currentChars[i];
            if (charToCheck == currentConsonant){
                fourthWordToFill.replace(i,i+1, String.valueOf(currentConsonant));
                hiddenArray[3] = fourthWordToFill.toString();
            }

        }
    }

    private static void FillVowels(String[] hiddenArray, String firstWordToCheck, String secondWordToCheck, String thirdWordToCheck, String fourthWordToCheck, StringBuilder firstWordToFill, StringBuilder secondWordToFill, StringBuilder thirdWordToFill, StringBuilder fourthWordToFill, char currentVowel) {
        for (int i = 0; i < firstWordToCheck.toCharArray().length; i++) {
            char[] currentChars = firstWordToCheck.toCharArray();
            char charToCheck = currentChars[i];
            if (charToCheck == currentVowel){
                firstWordToFill.replace(i,i+1, String.valueOf(currentVowel));
                hiddenArray[0] = firstWordToFill.toString();
            }

        }
        for (int i = 0; i < secondWordToCheck.toCharArray().length; i++) {
            char[] currentChars = secondWordToCheck.toCharArray();
            char charToCheck = currentChars[i];
            if (charToCheck == currentVowel){
                secondWordToFill.replace(i,i+1, String.valueOf(currentVowel));
                hiddenArray[1] = secondWordToFill.toString();
            }

        }
        for (int i = 0; i < thirdWordToCheck.toCharArray().length; i++) {
            char[] currentChars = thirdWordToCheck.toCharArray();
            char charToCheck = currentChars[i];
            if (charToCheck == currentVowel){
                thirdWordToFill.replace(i,i+1, String.valueOf(currentVowel));
                hiddenArray[2] = thirdWordToFill.toString();
            }

        }
        for (int i = 0; i < fourthWordToCheck.toCharArray().length; i++) {
            char[] currentChars = fourthWordToCheck.toCharArray();
            char charToCheck = currentChars[i];
            if (charToCheck == currentVowel){
                fourthWordToFill.replace(i,i+1, String.valueOf(currentVowel));
                hiddenArray[3] = fourthWordToFill.toString();
            }

        }
    }
}
