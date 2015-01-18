package com.opentable.tictactoe.game;

public enum GameState {
    /**
     * Initial state of the game when board,player will initialize
     */
    NOT_STARTED,
    /**
     * Running state when every player will enter their legal turn. This will be the state
     * till the game will have {@link com.opentable.tictactoe.game.GameState#WIN} state
     * or will have {@link com.opentable.tictactoe.game.GameState#TIE} state
     */
    RUNNING,
    /**
     * This is the on of the end state when game will have winner
     */
    WIN,
    /**
     * This is the on of the end state when game will have no winner
     */
    TIE
}
