package main.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product
                (1, "Book", 300, false, LocalDate.of(2023, 1, 15)));
        productList.add(new Product
                (2, "Toy", 50, true, LocalDate.of(2023, 2, 10)));
        productList.add(new Product
                (3, "Book", 200, true, LocalDate.of(2023, 3, 5)));
        productList.add(new Product
                (4, "Book", 350, false, LocalDate.of(2023, 4, 20)));
        productList.add(new Product
                (5, "Toy", 75, false, LocalDate.of(2023, 5, 10)));

        List<Product> expensiveBooks = Product.getExpensiveBooks(productList);
        List<Product> discountedBooks = Product.getDiscountedBooks(productList);
        Product cheapestBook = Product.findCheapestBook(productList);
        List<Product> latestProducts = Product.getLatestProducts(productList);
        double totalCost = Product.calculateTotalCost(productList);
        Map<String, List<Product>> groupedProducts = Product.groupProductsByType(productList);

        System.out.println("Дорогі книги:");
        expensiveBooks.forEach(product -> System.out.println(product.getId() + ": " + product.getPrice()));

        System.out.println("\nCкидочні книги:");
        discountedBooks.forEach(product -> System.out.println(product.getId() + ": " + product.getPrice()));

        System.out.println("\nНайдешевша книга:");
        System.out.println(cheapestBook.getId() + ": " + cheapestBook.getPrice());

        System.out.println("\nТри останні продукти:");
        latestProducts.forEach(product -> System.out.println(product.getId() + ": " + product.getCreateDate()));

        System.out.println("\nЗагальна вартість книг за поточний рік: " + totalCost);

        System.out.println("\nГрупи продуктів за типом:");
        groupedProducts.forEach((type, products) -> {
            System.out.println(type + ":");
            products.forEach(product -> System.out.println(product.getId()));
        });
    }
}
