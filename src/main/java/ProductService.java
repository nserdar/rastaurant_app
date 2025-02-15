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

    // Update an existing product's details
    public boolean updateProduct(int id, Product newProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, newProduct);
                return true;
            }
        }
        return false;
    }

    // Remove a product by its ID
    public boolean removeProduct(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    // Find all products belonging to a specific category
    public List<Product> findProductsByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                result.add(product);
            }
        }
        return result;
    }

    // Clear all products from the list
    public void clearProducts() {
        products.clear();
    }
}
