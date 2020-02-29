package snakegame;
/**
 *
 * @author NIMAS
 */
public class Cell {
    private final int row;
    private final int column;
    
    private CellType cellType;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
}
