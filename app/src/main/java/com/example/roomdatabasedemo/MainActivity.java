package com.example.roomdatabasedemo;

//import androidx.appcompat.app.AppCompatActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.example.roomdatabasedemo.room.ObjectViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_PRODUCT_REQUEST = 1;
    private ObjectViewModel objectViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final ProductAdapter adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);


        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_note);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
            startActivityForResult(intent, ADD_PRODUCT_REQUEST);
        });

        objectViewModel = ViewModelProviders.of(this).get(ObjectViewModel.class);
        objectViewModel.getAllProducts().observe(this, products -> adapter.setProducts(products));


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                objectViewModel.delete(adapter.getProductAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Note deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_PRODUCT_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(AddProductActivity.EXTRA_TITLE);
            String price = data.getStringExtra(AddProductActivity.EXTRA_PRICE);

            Product product = new Product(title, price);
            objectViewModel.insert(product);
            Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Product not Added", Toast.LENGTH_SHORT).show();
        }
    }

//    Call<ActivePackagesResponse> call = RetrofitClient.getInstance().getApi().GetMyActivepPkgs("Bearer " + token);
//        call.enqueue(new Callback<ActivePackagesResponse>() {
//        @Override
//        public void onResponse(Call<ActivePackagesResponse> call, Response<ActivePackagesResponse> response) {
//            if (response.isSuccessful()) {
//                progressDialog.dismiss();
//                mypkgList = response.body().getData();
//
//                pkgAdapter = new MyPackageAdapter(getActivity(), mypkgList,client,lc);
//                pkgRecycler.setAdapter(pkgAdapter);
//                progressDialog.dismiss();
//            }else{
//                //Toast.makeText(getContext(), response.code()+" - "+response.message(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();
//            }
//        }
//
//        @Override
//        public void onFailure(Call<ActivePackagesResponse> call, Throwable t) {
//            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            progressDialog.dismiss();
//        }
//    });
}