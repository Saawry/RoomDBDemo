package com.example.roomdatabasedemo.room;

//import androidx.lifecycle.LiveData;
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//import androidx.room.Update;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.actor.Actor;

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





    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertActors(List<Actor> actorList);

    @Query("delete from actor_table")
    void deleteAllActors();

    @Query("select * from actor_table")
    LiveData<List<Actor>> getAllActor();


}
