package main.java;

import java.util.ArrayList;
import java.util.List;

//OrderService sınıfı, siparişleri yönetir:
// Sipariş oluşturma, listeleme gibi işlemler burada tanımlanır.
public class OrderService {
    private List<Order> orderList = new ArrayList<>();

    //sipariş oluşturma:
    public void createOrder(Order order){
        orderList.add(order);
    }

    //sipariş listeleme:
    public List<Order> listOrder(){
        return orderList;
    }

    //id'ye göre sipariş arama:
    public String findOrderById(int id){
        for (Order order: orderList){
            if (order.getOrderId() == id){
                return id + " id'li siparişiniz: " + order;
            }
        }
        return "Sipariş Yok";
    }

    //category'ye göre arama:
    public List<Order> findOrderByCategory(Category category){
        List<Order> matchingOrder = new ArrayList<>();

        for (Order order: orderList){
            for (Product product: order.getProducts()){
                if (product.getCategory() == category){
                    matchingOrder.add(order);
                    break;// Bir eşleşme bulunduğunda diğer ürünlere bakmaya gerek yok
                }
            }
        }
        return matchingOrder;
    }
}
