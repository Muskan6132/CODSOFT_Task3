package wordCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounterString {
	//  user to enter a text or provide a file
    private static String getUserInput() throws IOException {
    	System.out.println(" Welcome to Muskan Word Counter:-");
        System.out.println("Enter your text or file name to count the words:");
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        return reader.readLine();
    }

    //  Read the input text or file and store it in a string
    private static String readTextOrFile(String userInput) throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader fileReader = new BufferedReader(new FileReader(userInput));
            String lineNo;
            while ((lineNo = fileReader.readLine()) != null) {
                sb.append(lineNo).append("\n");
            }
            fileReader.close();
            return sb.toString();
        } catch (IOException e) {
            return userInput;
        }
    }

    //  Split the string into an array of words using space or punctuation as delimiters
    private static String[] splitIntoWords(String text) {
        // Use regex to split words by spaces or punctuation
        return text.toLowerCase().split("[\\p{Punct}\\s]+");
    }

    //  Count the words
    private static Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> wordCounter = new HashMap<>();
        for (String word : words) {
            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        }
        return wordCounter;
    }

    // Display the total count of words to the user
    private static void displayWordCount(int totalWords, Map<String, Integer> wordCounter) {
        System.out.println("\nTotal number of words: " + totalWords + "\n");
        System.out.println("Word Counter:");
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            
            
        }
        System.out.print("Thank you");
    }

    // Main Method
    public static void main(String[] args) throws IOException {
        String userInput = getUserInput();
        if (userInput.trim().isEmpty()) {
            System.out.println("Input is empty. Please provide some text.");
            return;
        }

        String text = readTextOrFile(userInput);
        String[] words = splitIntoWords(text);
        int totalWords = words.length;
        Map<String, Integer> wordCounter = countWords(words);
        displayWordCount(totalWords, wordCounter);
    }

}
