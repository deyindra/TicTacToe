package com.opentable.tictactoe.game.exception;


public class GameException extends Exception {
    public GameException(String s) {
        super(s);
    }

    public GameException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
