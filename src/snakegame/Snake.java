package snakegame;

import java.util.LinkedList;

/**
 *
 * @author NIMAS
 */
public class Snake {

    private LinkedList<Cell> snakesPartlist = new LinkedList<>();
    private Cell snakeHead;

    public Snake(Cell initPosition) {
        this.snakeHead = initPosition;
        snakesPartlist.add(snakeHead);
    }

    public void grow() {
        snakesPartlist.add(snakeHead);
    }

    public void move(Cell nextCell) {
        System.out.println("Snake is moving to " + "[" + nextCell.getRow() + "]" + "[" + nextCell.getColumn() + "]");
        Cell tail = snakesPartlist.removeLast();
        tail.setCellType(CellType.EMPTY);
        
        this.snakeHead = nextCell;
        this.snakesPartlist.add(snakeHead);
        this.snakeHead.setCellType(CellType.SNAKE_NODE);
    }
    
    public boolean checkCrash(Cell nextCell){
        System.out.println("Going to check for crash");
        for ( Cell cell : snakesPartlist) {
            if(cell == nextCell){
                return true;
            }
        }
        return false;
    }

    public LinkedList<Cell> getSnakesPartlist() {
        return snakesPartlist;
    }

    public void setSnakesPartlist(LinkedList<Cell> snakesPartlist) {
        this.snakesPartlist = snakesPartlist;
    }

    public Cell getSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(Cell snakeHead) {
        this.snakeHead = snakeHead;
    }
    
    

}
