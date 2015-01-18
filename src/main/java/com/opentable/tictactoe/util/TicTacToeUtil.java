package com.opentable.tictactoe.util;

public class TicTacToeUtil {
    private TicTacToeUtil(){
        throw new AssertionError("can not instantiate the utility class");
    }

    /**
     * Return Cell Index based on the row and col index, throws {@link java.lang.IllegalArgumentException} in case
     * rowIndex<0 or colIndex<0 or width <=0
     * @param rowIndex rowIndex of the NXN grid 0 based
     * @param colIndex colIndex of the NXN grid 0 based
     * @param width width of the NXN grid
     * @throws java.lang.IllegalArgumentException
     * @return cellIndex
     */
    public static int getCellIndex(int rowIndex, int colIndex, int width){
        if(rowIndex<0){
            throw new IllegalArgumentException("Invalid row index");
        }

        if(colIndex<0){
            throw new IllegalArgumentException("Invalid col index");
        }

        if(width<=0){
            throw new IllegalArgumentException("Invalid width");
        }

        return (rowIndex*width) + colIndex;
    }

    /**
     * Return rowIndex based on cellIndex. throws {@link java.lang.IllegalArgumentException}
     * in case cellIndex < 0 or width<=0
     * @param cellIndex current cellIndex, 0 based
     * @param width width of the NXN grid
     * @throws java.lang.IllegalArgumentException
     * @return return rowIndex which is 0 based
     */
    public static int getRowIndex(int cellIndex, int width){
        if(cellIndex<0){
            throw new IllegalArgumentException("Invalid cell index");
        }

        if(width<=0){
            throw new IllegalArgumentException("Invalid width");
        }
        return (width/cellIndex);
    }

    /**
     * Return colIndex based on cellIndex. throws {@link java.lang.IllegalArgumentException}
     * in case cellIndex < 0 or width<=0
     * @param cellIndex current cellIndex 0 based
     * @param width width of the NXN grid
     * @throws java.lang.IllegalArgumentException
     * @return return colIndex which is 0 based
     */
    public static int getColIndex(int cellIndex, int width){
        if(cellIndex<0){
            throw new IllegalArgumentException("Invalid cell index");
        }

        if(width<=0){
            throw new IllegalArgumentException("Invalid width");
        }
        return (width%cellIndex);
    }

}
