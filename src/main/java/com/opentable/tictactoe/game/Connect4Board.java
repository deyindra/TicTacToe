package com.opentable.tictactoe.game;

import com.opentable.tictactoe.cell.Cell;
import com.opentable.tictactoe.game.exception.GameException;



public class Connect4Board extends Board{
    public Connect4Board(String player1Name, String player2Name) throws GameException {
        super(6, 4, player1Name, player2Name);
    }

    @Override
    protected void initialize(int size, int connectedSpace) {
        for(int row=0; row<size-1;row++){
            for(int col=0;col<size;col++){
                cells[row][col]=null;
            }
        }
        for(int col=0;col<size;col++){
            cells[size-1][col]=new Cell();
        }
        /**
         * Fill all the row side with connected moves
         */
        filledAllRowsWiseValidMoves(size, connectedSpace);
        /**
         * Fill all the col side with connected moves
         */
        filledAllColWiseValidMoves(size, connectedSpace);


    }

    public static void main(String[] args) throws GameException {
        System.out.println(new Connect4Board("A","B"));
    }
}
