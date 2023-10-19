package main.java.lesson11;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Product {
    private int id;
    private String type;
    private double price;
    private boolean discount;
    private LocalDate createDate;

    public Product(int id, String type, double price, boolean discount, LocalDate createDate) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public static List<Product> getExpensiveBooks(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedBooks(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getType().equals("Book") && product.isDiscount())
                .map(product -> new Product(
                        product.getId(),
                        product.getType(),
                        product.getPrice() * 0.9,
                        false, product.getCreateDate()))
                .collect(Collectors.toList());
    }

    public static Product findCheapestBook(List<Product> productList) {
        Optional<Product> cheapestBook = productList.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice));

        if (cheapestBook.isPresent()) {
            return cheapestBook.get();
        } else {
            throw new RuntimeException("Продукт [категорія: Book] не знайдено");
        }
    }

    public static List<Product> getLatestProducts(List<Product> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static double calculateTotalCost(List<Product> productList) {
        int currentYear = LocalDate.now().getYear();
        return productList.stream()
                .filter(product -> product.getType().equals("Book"))
                .filter(product -> product.getCreateDate().getYear() == currentYear)
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupProductsByType(List<Product> productList) {
        return productList.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}