package main.java;

import java.util.ArrayList;
import java.util.List;

//ProductService, ürünleri yönetir: Ürün ekleme, listeleme, arama gibi işlemler burada tanımlanır.
public class ProductService {
    private List<Product> products = new ArrayList<>();

    //ürün ekleme:
    public void addProduct(Product product){
        products.add(product);
    }

    //ürün listeleme:
    public List<Product> listProduct(){
        return products;
    }

    // id'ye göre ürün arama:
    public String findProductById(int id){
        for (Product product: products){
            if (product.getId() == id){
                return id + " id'li ürün bulundu. Ürününüz: " +product;
            }
        }
        return "Ürün Bulunamadı";
    }
}
