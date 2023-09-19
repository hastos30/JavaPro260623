package main.java.lesson16.game;

import java.util.Scanner;

public class TicTacToeGame {
    private TicTacToeStrategy strategy;

    public void setStrategy(TicTacToeStrategy strategy) {
        this.strategy = strategy;
    }

    public void playGame() {
        strategy.initializeGame();
        Scanner scanner = new Scanner(System.in);

        while (!strategy.isGameOver()) {
            strategy.printBoard();
            System.out.print("Игрок " + strategy.getCurrentPlayer() + ", введите строку (0-2) и столбец (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            strategy.makeMove(row, col);
        }

        strategy.printBoard();
        System.out.println("Игра окончена!");
    }
}
