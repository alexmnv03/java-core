package collectionsframework.collections.set.treeset;

import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Рассмотрим одно из практических применений множеста.
 * Допустим нам необходимо получить перечень всех слов в файле worlds.txt
 */
public class UniqueWords {
    public static void main(String[] args) {
        String fileName = "worlds.txt";
        Set<String> wordList =
                new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        try (BufferedReader in = new BufferedReader(new FileReader(
                new File(fileName).getAbsoluteFile()))) {
            String line;
            while((line = in.readLine()) != null) {
                Collections.addAll(wordList, line.split(" "));
            }
        } catch(IOException e) {
            System.out.println(e);
        }
        System.out.println(wordList);
    }
}

