package com.example.roomdatabasedemo.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.students.StudentInfo;

import java.util.List;

public class ObjectViewModel extends AndroidViewModel {

    private ModelRepository modelRepository;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<StudentInfo>> allStudents;

    public ObjectViewModel(@NonNull Application application) {
        super(application);
        modelRepository = new ModelRepository(application);
        allProducts = modelRepository.getAllProducts();
        allStudents = modelRepository.getAllStudents();
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


    //-------------Student
    public void insertStudent(Product product) {
        modelRepository.insert(product);
    }

    public void updateStudent(Product product) {
        modelRepository.update(product);
    }

    public void deleteStudent(Product product) {
        modelRepository.delete(product);
    }

    public void deleteAllStudents() {
        modelRepository.deleteAllProducts();
    }

    public LiveData<List<StudentInfo>> getAllStudents() { return allStudents; }
}
