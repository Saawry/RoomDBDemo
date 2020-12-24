package com.example.roomdatabasedemo.room;

//import androidx.lifecycle.LiveData;
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//import androidx.room.Update;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.actor.Actor;
import com.example.roomdatabasedemo.students.StudentInfo;

import java.util.List;

@Dao
public interface ModelDAO {

    @Insert
    void insertProduct(Product product);

    @Delete
    void deleteProduct(Product product);

    @Update
    void updateProduct(Product product);

    @Query("select * from product_table")
    LiveData<List<Product>> getAllProducts();

    @Query("delete from product_table")
    void deleteAllProducts();


    @Insert
    void insertStudent(StudentInfo studentInfo);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllStudent(List<StudentInfo> studentsInfo);

    @Delete
    void deleteStudent(StudentInfo studentInfo);

    @Update
    void updateStudent(StudentInfo studentInfo);

    @Query("select * from students_info_table")
    LiveData<List<StudentInfo>> getAllStudents();

    @Query("delete from students_info_table")
    void deleteAllStudents();



    //--------
    @Query("select * from actor_table")
    LiveData<List<Actor>> getAllActors();

    @Insert
    void insertActors(List<Actor> actor);


}
