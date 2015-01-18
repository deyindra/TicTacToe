package com.opentable.tictactoe.cell;

/**
 * Basic purpose of this class is to represent a cell on nXn tic-tac-toe board which contains
 * either 0 or 1 for 1st player, 2 for 2nd Player
 * @author indranildey
 * @see com.opentable.tictactoe.cell.CellType
 */
public class Cell {
    private CellType cellType;

    public Cell(CellType cellType) {
        this.cellType = cellType;
    }

    public Cell() {
        this(CellType.LEGAL_CELL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (cellType != cell.cellType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return cellType != null ? cellType.hashCode() : 0;
    }
}
