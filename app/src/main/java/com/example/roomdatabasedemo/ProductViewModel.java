package com.example.roomdatabasedemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository productRepository;
    private LiveData<List<Product>> allProducts;
    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepository(application);
        allProducts = productRepository.getAllProducts();
    }

    public void insert(Product product) {
        productRepository.insert(product);
    }
    public void update(Product product) {
        productRepository.update(product);
    }
    public void delete(Product product) {
        productRepository.delete(product);
    }
    public void deleteAll() {
        productRepository.deleteAllProducts();
    }
    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }
}
