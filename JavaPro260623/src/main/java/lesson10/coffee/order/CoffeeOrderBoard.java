package main.java.lesson10.coffee.order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CoffeeOrderBoard {

    private List<Order> orderList;
    private int lastOrderNumber;

    public CoffeeOrderBoard() {
        orderList = new ArrayList<>();
        lastOrderNumber = 0;
    }

    public void addOrder(String customerName) {
        lastOrderNumber++;
        Order newOrder = new Order(lastOrderNumber, customerName);
        orderList.add(newOrder);
        System.out.println("Order added: " + newOrder.getOrderNumber() + " - " + newOrder.getCustomerName());
    }

    public Order deliver(int orderNumber) {
        Order requestedOrder = orderList.stream()
                .filter(order -> order.getOrderNumber() == orderNumber)
                .findFirst()
                .orElse(null);

        if (requestedOrder != null) {
            orderList.remove(requestedOrder);
            System.out.println("Order delivered: " + requestedOrder.getOrderNumber() + " - " + requestedOrder.getCustomerName());
        } else {
            System.out.println("Order not found: " + orderNumber);
        }
        return requestedOrder;
    }

    public void draw() {
        System.out.println("=============");
        System.out.println("Num | Name");

        List<Order> sortedOrders = orderList.stream()
                .sorted(Comparator.comparingInt(Order::getOrderNumber))
                .collect(Collectors.toList());

        for (Order order : sortedOrders) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }
    }
}