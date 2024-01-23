# Hangman Game
Welcome to the Hangman Game! This is a simple command-line Hangman game implemented in Java using Spring Boot.

## Installation

1. Clone the repository to your local machine:

```shell
git clone https://github.com/your-username/hangman-game.git
```

2. Navigate to the project directory:

```shell
cd hangman-cli
```

3. Build the project using Gradle:

```shell
./gradlew build
```

## Usage

1. Run the Hangman game:

```shell
./gradlew bootRun
```

2. The game will display a welcome message and menu options:

```
Welcome to Hangman!
1) Start Game
2) Exit
Enter choice:
```

3. Enter `1` to start a new game or `2` to exit.

4. If you choose to start the game, a random word will be selected, and the Hangman interface will be displayed:

```
+---+
 |
 |
 |
 |
 |
 |
 |
=====
```

5. You can guess a letter or the entire word, and the game will provide feedback on your guess.

6. The game continues until you guess the word correctly or run out of attempts.

7. If you win, you'll see a congratulatory message, and if you lose, you'll see a game over message.

8. You can choose to start a new game or exit the program.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.