package main.java.lesson10.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.addOrder("Viktor");
        orderBoard.addOrder("Jenia");
        orderBoard.addOrder("Vova");
        orderBoard.addOrder("Sasha");

        orderBoard.draw();

        orderBoard.deliver(2);
        orderBoard.deliver(3);

        orderBoard.draw();
    }
}
