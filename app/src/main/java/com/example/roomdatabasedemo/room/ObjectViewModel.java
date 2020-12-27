package com.example.roomdatabasedemo.room;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.actor.Actor;

import java.util.List;

public class ObjectViewModel extends AndroidViewModel {

    private ModelRepository modelRepository;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<Actor>> allActors;

    public ObjectViewModel(@NonNull Application application) {
        super(application);
        modelRepository = new ModelRepository(application);
        allProducts = modelRepository.getAllProducts();
        allActors = modelRepository.getAllActors();
    }


    //-------------Product
    public void insert(Product product) {
        modelRepository.insert(product);
    }

    public void update(Product product) {
        modelRepository.update(product);
    }

    public void delete(Product product) {
        modelRepository.delete(product);
    }

    public void deleteAll() {
        modelRepository.deleteAllProducts();
    }

    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }


    public void InsertActors(List<Actor> actors){
        modelRepository.InsertActors(actors);
    }

    public LiveData<List<Actor>> getActorList(){
        return allActors;
    }
}
