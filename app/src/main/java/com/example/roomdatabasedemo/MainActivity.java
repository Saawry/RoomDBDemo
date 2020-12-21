package com.example.roomdatabasedemo;

//import androidx.appcompat.app.AppCompatActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productViewModel=  ViewModelProviders.of(MainActivity.this).get(ProductViewModel.class);
        productViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                //recycler view
                Toast.makeText(MainActivity.this, "....", Toast.LENGTH_SHORT).show();
            }
        });
    }
}