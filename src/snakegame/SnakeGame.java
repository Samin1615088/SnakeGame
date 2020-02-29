package snakegame;

import java.util.Scanner;

/**
 *
 * @author NIMAS
 */
public class SnakeGame {

    /**
     * @param args the command line arguments
     */
    private Snake snake;
    private Board board;
    private int direction;
    private boolean gameOver;
    private static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1, DIRECTION_LEFT = -1, DIRECTION_TOP = 2, DIRECTION_DOWN = -2;

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Going to start the game");
        Cell initPoisition = new Cell(0, 0);
        Snake initSnake = new Snake(initPoisition);
        Board board = new Board(10, 10);
        SnakeGame snakeGame = new SnakeGame(initSnake, board);
        snakeGame.gameOver = false;

        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                snakeGame.board.generateFood();
            }
            snakeGame.update();
            if (i == 3) {
                snakeGame.direction = DIRECTION_RIGHT;
            }
            if (snakeGame.gameOver == true) {
                break;
            }
        }

//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("\nPlease enter");
//            System.out.println("press 4 to move left\n"
//                    + "press 6 to move right\n"
//                    + "press 8 to move top\n"
//                    + "press 2 to move down\n");
//
//            int move = sc.nextInt();
//            Cell foodCell = snakeGame.board.generateFood();
//
//            switch (move) {
//                case 4:
//                    System.out.println("\nPlease enter again");
//                    snakeGame.direction = DIRECTION_LEFT;
//                    snakeGame.snake.move(snakeGame.snake.getSnakeHead());
//                    break;
//                case 6:
//                    System.out.println("\nPlease enter again");
//                    snakeGame.direction = DIRECTION_RIGHT;
//                    break;
//                case 8:
//                    System.out.println("\nPlease enter again");
//                    snakeGame.direction = DIRECTION_TOP;
//                    break;
//                case 2:
//                    System.out.println("\nPlease enter again");
//                    snakeGame.direction = DIRECTION_DOWN;
//                    break;
//                default:
//                    break;
//            }
//        }
    }

    public SnakeGame(Snake snake, Board board) {
        this.snake = snake;
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void update() {
        System.out.println("Going to update the game");
        if (!gameOver) {
            if (direction != DIRECTION_NONE) {
                Cell nextCell = getNextCell(snake.getSnakeHead());

                if (snake.checkCrash(nextCell)) {
                    setDirection(DIRECTION_NONE);
                    this.gameOver = true;
                } else {
                    snake.move(nextCell);
                    if (nextCell.getCellType() == CellType.FOOD) {
                        snake.grow();
                        board.generateFood();
                    }
                }
            }
        }
    }

    public Cell getNextCell(Cell currentPoisition) {
        System.out.println("Going to find next cell ");
        int row = currentPoisition.getRow();
        int col = currentPoisition.getColumn();

        switch (this.direction) {
            case DIRECTION_LEFT:
                col--;
                break;
            case DIRECTION_RIGHT:
                col++;
                break;
            case DIRECTION_TOP:
                row++;
                break;
            case DIRECTION_DOWN:
                row--;
                break;
            default:
                break;
        }
        Cell nextCell = board.getCells()[row][col];
        return nextCell;
    }

}
