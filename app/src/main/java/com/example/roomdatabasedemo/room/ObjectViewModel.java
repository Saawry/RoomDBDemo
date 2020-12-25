package com.example.roomdatabasedemo.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.actor.Actor;
import com.example.roomdatabasedemo.actor.ActorActivity;
import com.example.roomdatabasedemo.students.StudentInfo;

import java.util.List;

public class ObjectViewModel extends AndroidViewModel {

    private ModelRepository modelRepository;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<StudentInfo>> allStudents;
    private LiveData<List<Actor>> allActors;

    public ObjectViewModel(@NonNull Application application) {
        super(application);
        modelRepository = new ModelRepository(application);
        allProducts = modelRepository.getAllProducts();
        allStudents = modelRepository.getAllStudents();
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


    //-------------Student
    public void insertStudent(StudentInfo studentInfo) {
        modelRepository.InsertStudent(studentInfo);
    }
    public void InsertAllStudent(List<StudentInfo> studentInfo) {
        modelRepository.InsertAllStudent(studentInfo);
    }

    public void updateStudent(StudentInfo studentInfo) {
        modelRepository.UpdateStudent(studentInfo);
    }

    public void deleteStudent(StudentInfo studentInfo) {
        modelRepository.DeleteStudent(studentInfo);
    }

    public void deleteAllStudents() {
        modelRepository.deleteAllProducts();
    }

    public LiveData<List<StudentInfo>> getAllStudents() { return allStudents; }


    public LiveData<List<Actor>> getAllActors() { return allActors; }
}
