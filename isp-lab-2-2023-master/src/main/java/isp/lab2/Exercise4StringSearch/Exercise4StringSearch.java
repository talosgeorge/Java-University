package isp.lab2.Exercise4StringSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4StringSearch {
    /**
     * This method should return an array of strings that contain the substring.
     * @param input
     * @param substring what to search for
     * @return
     */
    public static String[] searchSubstrings(String input, String substring) {
        String[] splitInput = input.split(",");
        ArrayList<String> result = new ArrayList<>();
        for(String str:splitInput){
            if(str.contains(substring))
                result.add(str);
        }
        return result.toArray(new String[0]);
    }

    public static String readFromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input = readFromConsoleInt();
        String substring = readFromConsoleInt();
        //String input = "apples,computer,bread,tea,car";
        //String substring = "te";
        String[] result = searchSubstrings(input, substring);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
