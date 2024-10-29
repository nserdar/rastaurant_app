package main.java;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        //ürün oluşturma:
        Product product1 = new Product(1, "Pizza", 50.0, "Cheese Pizza", Category.MAIN_COURSE);
        Product product2 = new Product(2, "Burger", 30.0, "Beef Burger", Category.MAIN_COURSE);
        Product product3 = new Product(3, "Coke", 10.0, "Cold Drink", Category.BEVERAGE);
        Product product4 = new Product(4, "Tiramisu", 20.0, "Coffee Dessert", Category.DESSERT);

        // Ürünleri ekle
        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
        productService.addProduct(product4);

        // Sipariş oluştur
        Order order1 = new Order(1);
        order1.addProduct(product1);  // 1. sipariş: 1. üründen
        order1.addProduct(product3);  // ve 3. üründen isteniyor

        Order order2 = new Order(2);
        order2.addProduct(product2);
        order2.addProduct(product4);

        orderService.createOrder(order1);
        orderService.createOrder(order2);

        // Kategoriye göre sipariş bulma:
        List<Order> beverageOrders = orderService.findOrderByCategory(Category.BEVERAGE);
        System.out.println("Beverage Orders: ");
        for (Order order : beverageOrders){
            System.out.println(order);
        }
    }
}
