package com.alison.hangmancli;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HangmanApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printGameBanner();

        while (true) {
            try {
                System.out.println("Welcome to Hangman!");
                System.out.println("1) Start Game\n2) Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    String word = WordLoader.loadRandomWord("src/main/resources/words.txt");
                    HangmanGame game = new HangmanGame(word);
                    gameLoop(scanner, game);
                } else if (choice == 2) {
                    break; // Exit the game
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        scanner.close();
    }

    private static void gameLoop(Scanner scanner, HangmanGame game) {
        while (!game.isGameOver() && !game.isWordGuessed()) {
            System.out.println(game.getCurrentState());
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().charAt(0);

            if (!game.guessLetter(guess)) {
                System.out.println("Wrong guess. Try again.");
            }

            if (game.isWordGuessed()) {
                System.out.println("Congratulations! You guessed the word: " + game.getWord());
                break; // Word guessed correctly
            } else if (game.isGameOver()) {
                System.out.println("Game Over. The word was: " + game.getWord());
            }
        }
    }

    private static void printGameBanner() {
        System.out.println("\nHangman Game\n");
    }
}
