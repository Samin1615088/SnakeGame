package snakegame;

/**
 *
 * @author NIMAS
 */
public class Board {

    private final int rowCount;
    private final int columnCount;

    private Cell[][] cells;
    private Cell foodCell;

    public Board(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.cells = new Cell[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                this.cells[row][col] = new Cell(row, col);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell getFoodCell() {
        return foodCell;
    }

    public Cell generateFood() {
        int row = (int) (Math.random() * rowCount);
        int col = (int) (Math.random() * columnCount);

        cells[row][col].setCellType(CellType.FOOD);
        System.out.println("Food is generated at " + "[" + row + "]" + "[" + col + "]");
        return cells[row][col];
    }

}
