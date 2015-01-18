package com.opentable.tictactoe.game;

import com.opentable.tictactoe.cell.Cell;
import com.opentable.tictactoe.game.exception.GameException;

import java.util.ArrayList;
import java.util.List;


public abstract class Board {
    /**
     * Tow dimensional Array defines the cell in the NXN board.
     * Initial cell value either be null or {@link com.opentable.tictactoe.cell.Cell} object
     * with cellType {@link com.opentable.tictactoe.cell.CellType#LEGAL_CELL}
     */
    protected Cell[][] cells;
    /**
     * tow dimensional array define the legal move
     */
    protected List<int[]> validMoves;
    /**
     * State of the game
     */
    protected GameState state;
    /**
     * Player array of size 2
     */
    protected Player[] players;
    /**
     * Define who is the current Player {@link com.opentable.tictactoe.game.Player}
     */
    protected Player currentPlayer;
    /**
     * Define the player turn count which is 0 based index
     */
    protected int playerTurnCount;

    protected Board(final int size, final int connectedSpace, String player1Name, String player2Name) throws GameException{
        if(size<2){
            throw new GameException("Invalid Board size, it should be greater than or equal to 2");
        }
        if(connectedSpace>size){
            throw new GameException(String.format("Connected space should less than or equal to %d", size));
        }
        if(player1Name==null || ("").equals(player1Name.trim())){
            throw new GameException("Illegal Player1 name");
        }

        if(player2Name==null || ("").equals(player2Name.trim())){
            throw new GameException("Illegal Player2 name");
        }
        this.state = GameState.NOT_STARTED;
        this.playerTurnCount = 0;
        players = new Player[]{new Player(1,player1Name.trim()), new Player(2, player2Name.trim())};
        currentPlayer = getCurrentPlayer();
        cells = new Cell[size][size];
        initialize(size,connectedSpace);
    }

    protected abstract void initialize(final int size, final int connectedSpace);

    protected Player getCurrentPlayer(){
        return this.players[(playerTurnCount%this.players.length)];
    }

    protected void filledAllRowsWiseValidMoves(final int size, final int connectedSpace){
        int loopCount = size - connectedSpace + 1;
        for(int startIndex=0;startIndex<size;startIndex++){
            for(int count=0;count<loopCount;count++){
                int[] move = new int[connectedSpace];
                for(int index=0;index<connectedSpace;index++){
                    move[index]=(startIndex*size)+ index+count;
                }
                if(validMoves==null){
                    validMoves = new ArrayList<int[]>();
                }
                validMoves.add(move);
            }
        }
    }

    protected void filledAllColWiseValidMoves(final int size, final int connectedSpace){
        int loopCount = size - connectedSpace + 1;
        for(int startIndex=0;startIndex<size;startIndex++){
            for(int count=0;count<loopCount;count++){
                int[] move = new int[connectedSpace];
                for(int index=0;index<connectedSpace;index++){
                    move[index]=startIndex+(index+count)*size;
                }
                if(validMoves==null){
                    validMoves = new ArrayList<int[]>();
                }
                validMoves.add(move);
            }
        }
    }
}
