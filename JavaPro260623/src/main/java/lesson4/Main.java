package lesson4;

public class Main {
    public static void main(String[] args) {
        Order number1 = new Order.OrderBuilder()
                .orderId("1")
                .customerName("Viktor Shapoval")
                .shippingAddress("Rabstynska 9/7, Warszawa, Poland")
                .paymentMethod("Cash")
                .build();
        System.out.println(number1);

    }
}
