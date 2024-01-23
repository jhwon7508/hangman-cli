package com.alison.hangmancli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HangmanGameTest {

    @Test
    public void testCorrectGuess() {
        HangmanGame game = new HangmanGame("test");
        assertTrue(game.guessLetter('t'));
    }

    @Test
    public void testWrongGuess() {
        HangmanGame game = new HangmanGame("test");
        assertFalse(game.guessLetter('a'));
    }

    @Test
    public void testWordGuessed() {
        HangmanGame game = new HangmanGame("test");
        game.guessLetter('t');
        game.guessLetter('e');
        game.guessLetter('s');
        assertTrue(game.isWordGuessed());
    }
}
