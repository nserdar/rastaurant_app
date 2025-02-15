package main.java;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orderList = new ArrayList<>();

    // Create an order
    public void createOrder(Order order) {
        orderList.add(order);
    }

    // List all orders
    public List<Order> listOrder() {
        return orderList;
    }

    // Find order by ID
    public String findOrderById(int id) {
        for (Order order : orderList) {
            if (order.getOrderId() == id) {
                return id + " id'li siparişiniz: " + order;
            }
        }
        return "Sipariş Yok";
    }

    // Find orders by category
    public List<Order> findOrderByCategory(Category category) {
        List<Order> matchingOrder = new ArrayList<>();
        for (Order order : orderList) {
            for (Product product : order.getProducts()) {
                if (product.getCategory() == category) {
                    matchingOrder.add(order);
                    break; // Stop checking other products in the order
                }
            }
        }
        return matchingOrder;
    }

    // Update a product in an order
    public boolean updateProductInOrder(int orderId, int productId, Product newProduct) {
        for (Order order : orderList) {
            if (order.getOrderId() == orderId) {
                for (int i = 0; i < order.getProducts().size(); i++) {
                    if (order.getProducts().get(i).getId() == productId) {
                        order.getProducts().set(i, newProduct);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Remove a product from an order
    public boolean removeProductFromOrder(int orderId, int productId) {
        for (Order order : orderList) {
            if (order.getOrderId() == orderId) {
                return order.getProducts().removeIf(product -> product.getId() == productId);
            }
        }
        return false;
    }
}