package main.java.lesson16.strategies;

import main.java.lesson16.game.TicTacToeStrategy;

public class SimpleTicTacToeStrategy implements TicTacToeStrategy {
    private char[][] board;
    private char currentPlayer;

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void initializeGame() {
        board = new char[3][3];
        currentPlayer = 'X';
    }

    @Override
    public void makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == 0) {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    @Override
    public boolean isGameOver() {
        return checkWin('X') || checkWin('O') || isBoardFull();
    }

    private boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void printBoard() {
        System.out.println("Доска:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
