package main.java.lesson16;

import main.java.lesson16.game.TicTacToeGame;
import main.java.lesson16.game.TicTacToeStrategy;
import main.java.lesson16.strategies.SimpleTicTacToeStrategy;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        TicTacToeStrategy strategy = new SimpleTicTacToeStrategy();
        game.setStrategy(strategy);
        game.playGame();
    }
}