package com.opentable.tictactoe.cell;

/**
 * A enum  which represent either empty cell value which is 0, or player 1 value which is 1
 * or player 2 value which is 2
 * @author indranildey
 */
public enum  CellType {
    /** Empty cell value **/
    LEGAL_CELL(0),

    /** player 1 value **/
    PLAYER_1_CELL(1),

    /** player 2 value **/
    PLAYER_2_CELL(2);

    private int cellType;

    private CellType(int cellType) {
        this.cellType = cellType;
    }

    public int getCellType() {
        return cellType;
    }

    @Override
    public String toString() {
        return Integer.toString(cellType);
    }

    public static CellType get(int cellType){
        CellType returnCellType = null;
        for(CellType val:CellType.values()){
            if(cellType==val.cellType){
                returnCellType = val;
                break;
            }
        }
        if(returnCellType==null){
            throw new IllegalArgumentException("Invalid Cell Type");
        }
        return returnCellType;
    }
}
