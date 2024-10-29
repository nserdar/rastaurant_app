package main.java;

import java.util.ArrayList;
import java.util.List;

//Order sınıfı, siparişlerin bilgilerini ve sipariş edilen ürünleri içerir.
// Her sipariş, ürünlerin bir listesini ve toplam fiyat bilgisini tutar.
// Bir müşterinin belirli bir zaman diliminde verdiği siparişi temsil eder.
public class Order {
    private int orderId;
    private List<Product> products = new ArrayList<>();
    private double totalAmount;

    public Order(int orderId){
        this.orderId = orderId;
    }

    // ürün ve fiyatını ekleme:
    public void addProduct(Product product){
        products.add(product);
        totalAmount += product.getPrice();
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
