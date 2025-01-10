import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
    int totalWords = 0;

    int longestWordLength = 0;
    String longestWord = "";
    int shortestWordLength = Integer.MAX_VALUE;
    String shortestWord = "";
    int totalCharacters = 0;
    Map<String, Integer> wordCount = new HashMap<>();
    try {
        for (int i = 1; i <= 20; i++) {
            String fileName = "file" + i + ".txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    totalWords++;
                    int wordLength = word.length();
                    if (wordLength > longestWordLength) {
                        longestWordLength = wordLength;
                        longestWord = word;
                    }
                    if (wordLength < shortestWordLength) {
                        shortestWordLength = wordLength;
                        shortestWord = word;
                    }
                    totalCharacters += wordLength;
                    wordCount.merge(word, 1, Integer::sum);                    }
            }                reader.close();
        }
        double averageWordLength = (double) totalCharacters / totalWords;
        System.out.println("Word Analyzer Project - AP Lab Workshop 9");
        System.out.println("1) Words Count: " + totalWords);
        System.out.println("2) Longest word and its length: " + longestWord + " (" + longestWordLength + ")");            System.out.println("3) Shortest word and its length: " + shortestWord + " (" + shortestWordLength + ")");
        System.out.println("4) All words Length average: " + averageWordLength);
    } catch (IOException e) {
        e.printStackTrace();
        }
    }

}