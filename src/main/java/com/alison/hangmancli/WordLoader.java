package com.alison.hangmancli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordLoader {

    // Load a random word from the specified file
    public static String loadRandomWord(String filename) {
        try {
            List<String> words = Files.readAllLines(Paths.get(filename));
            return words.get(new Random().nextInt(words.size()));
        } catch (IOException e) {
            throw new RuntimeException("Error reading words file: " + filename, e);
        }
    }
}
