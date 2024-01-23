package com.alison.hangmancli;

import java.util.HashSet;
import java.util.Set;

public class HangmanGame {

    private static final int MAX_WRONG_GUESSES = 6; // Maximum wrong guesses before game over
    private String word; // The word to be guessed
    private Set<Character> guessedLetters; // Set of guessed letters
    private int wrongGuesses; // Number of wrong guesses

    // Constructor initializing the game
    public HangmanGame(String word) {
        this.word = word.toUpperCase();
        this.guessedLetters = new HashSet<>();
        this.wrongGuesses = 0;
    }

    // Method to guess a letter and update the game state
    public boolean guessLetter(char letter) {
        letter = Character.toUpperCase(letter);
        if (word.contains(String.valueOf(letter))) {
            guessedLetters.add(letter);
            return true;
        } else {
            wrongGuesses++;
            return false;
        }
    }

    // Method to guess the entire word
    public boolean guessWord(String guess) {
        return word.equalsIgnoreCase(guess);
    }

    // Check if the game is over
    public boolean isGameOver() {
        return wrongGuesses >= MAX_WRONG_GUESSES;
    }

    // Check if the word is completely guessed
    public boolean isWordGuessed() {
        for (char letter : word.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    // Get the current state of the game for display
    public String getCurrentState() {
        StringBuilder currentState = new StringBuilder("\n+---+\n |   |\n");
        if (wrongGuesses >= 1) currentState.append(" |   O\n");
        if (wrongGuesses >= 2) currentState.append(" |   |");
        if (wrongGuesses >= 3) currentState.append("\n |  /|");
        if (wrongGuesses >= 4) currentState.append("\\");
        if (wrongGuesses >= 5) currentState.append("\n |  / ");
        if (wrongGuesses >= 6) currentState.append("\\");
        currentState.append("\n |\n |\n=====\n");

        for (char letter : word.toCharArray()) {
            currentState.append(guessedLetters.contains(letter) ? letter : "*");
        }
        return currentState.toString();
    }

    // Get the word
    public String getWord() {
        return word;
    }
}
