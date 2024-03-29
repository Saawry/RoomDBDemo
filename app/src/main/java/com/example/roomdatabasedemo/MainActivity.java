package com.example.roomdatabasedemo;

//import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.widget.Toast;

import com.example.roomdatabasedemo.actor.ActorActivity;
import com.example.roomdatabasedemo.room.ObjectViewModel;

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
        FloatingActionButton buttonActor = findViewById(R.id.button_actor);
        buttonActor.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity.this, ActorActivity.class);
            startActivity(intent2);
        });
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
            startActivityForResult(intent, ADD_PRODUCT_REQUEST);
        });

        objectViewModel = new ViewModelProvider(this).get(ObjectViewModel.class);
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