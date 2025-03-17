import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f)", name, price);
    }
}

public class largeDataset {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
        new Product("Laptop", "Electronics", 65487.00),
        new Product("Microwave", "Appliance", 45889.00),
        new Product("TV", "Electronics", 13999.00),
        new Product("Smartphone", "Electronics", 34599.00),
        new Product("Table", "Furniture", 1099.00),
        new Product("Chair", "Furniture", 5799.00)
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        
        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((category, productList) -> 
            System.out.println(category + " -> " + productList)
        );

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                    Product::getCategory,
                    Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));
        
        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + " -> " + product.orElse(null))
        );

        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
        
        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
