package main.java;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        // Create products
        Product product1 = new Product(1, "Pizza", 50.0, "Cheese Pizza", Category.MAIN_COURSE);
        Product product2 = new Product(2, "Burger", 30.0, "Beef Burger", Category.MAIN_COURSE);
        Product product3 = new Product(3, "Coke", 10.0, "Cold Drink", Category.BEVERAGE);
        Product product4 = new Product(4, "Tiramisu", 20.0, "Coffee Dessert", Category.DESSERT);

        // Add products
        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
        productService.addProduct(product4);

        // Create orders
        Order order1 = new Order(1);
        order1.addProduct(product1);
        order1.addProduct(product3);

        Order order2 = new Order(2);
        order2.addProduct(product2);
        order2.addProduct(product4);

        orderService.createOrder(order1);
        orderService.createOrder(order2);

        // Find orders by category
        List<Order> beverageOrders = orderService.findOrderByCategory(Category.BEVERAGE);
        System.out.println("Beverage Orders: ");
        for (Order order : beverageOrders) {
            System.out.println(order);
        }

        // Update a product in an order
        Product newProduct = new Product(3, "Diet Coke", 12.0, "Diet Cold Drink", Category.BEVERAGE);
        boolean isUpdated = orderService.updateProductInOrder(1, 3, newProduct);
        System.out.println("Product updated: " + isUpdated);

        // Remove a product from an order
        boolean isRemoved = orderService.removeProductFromOrder(2, 4);
        System.out.println("Product removed: " + isRemoved);
    }
}