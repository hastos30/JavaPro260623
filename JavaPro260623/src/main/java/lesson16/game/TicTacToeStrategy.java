package main.java.lesson16.game;

public interface TicTacToeStrategy {
    void initializeGame();
    void makeMove(int row, int col);
    boolean isGameOver();
    void printBoard();
    char getCurrentPlayer();
}
