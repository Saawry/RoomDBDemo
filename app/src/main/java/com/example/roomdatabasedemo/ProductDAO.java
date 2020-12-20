package com.example.roomdatabasedemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {

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

}
