package isp.lab2.Exercise6WordGuess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exercise6WordGuess {

    public static List<String> generateDictionary() {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("mar");
        dictionary.add("banana");
        dictionary.add("pisica");
        dictionary.add("caine");
        dictionary.add("elefant");
        dictionary.add("broasca");
        dictionary.add("girafa");
        dictionary.add("palarie");
        dictionary.add("inghetata");
        dictionary.add("geaca");
        return dictionary;
    }
    private static void printDictionary(List<String> dictionary) {
        System.out.println("Dictionar:");
        for (String word : dictionary)
            System.out.println(word);
    }
    public static String generateRandomWord(List<String> dictionary){
        Random random = new Random();
        int index = random.nextInt(dictionary.size());
        return dictionary.get(index);
    }
    /**
     * This method will return the number of occurrences of a character in a word
     //* @param c
     //* @param word
    // * @return
     */
    public static int countOccurence(char c, char[] word) {
        int count = 0;
        for (char ch : word) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        List<String> dictionary = generateDictionary();
        String randomWord = generateRandomWord(dictionary);
        printDictionary(dictionary);
        int wordLength = randomWord.length();
        int tries = 0;
        boolean wordGuessed = false;
        boolean[] letterGuessed = new boolean[30];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuvant random: " + randomWord);
        System.out.println("Jocul incepe!");
        System.out.println("Incearca sa ghicesti cuvantul dand cate o litera rand pe rand.");
        System.out.println("Cuvantul are " + wordLength + " litere.");
        while (!wordGuessed) {
            System.out.print("Da o litera:");
            char letter = scanner.nextLine().toLowerCase().charAt(0);
            if (!Character.isLetter(letter)) {
                System.out.println("Da o litera valida.");
                continue;
            }
            letterGuessed[letter - 'a'] = true;
            int occurrences = countOccurence(letter, randomWord.toCharArray());
            if (occurrences > 0) {
                System.out.println("Litera nimerita! Apare de " + occurrences + " ori in cuvant");
            } else {
                System.out.println("Litera nu se afla in cuvant.");
            }
            tries++;
            boolean allLettersGuessed = true;
            for (int i = 0; i < wordLength; i++) {
                if (!letterGuessed[randomWord.charAt(i) - 'a']) {
                    allLettersGuessed = false;
                    break;
                }
            }
            if (allLettersGuessed) {
                wordGuessed = true;
                System.out.println("Ai ghicit cuvantul: " + randomWord);
                System.out.println("Ai incercat de: " + tries +" ori");
            }
        }
        scanner.close();
    }
}
