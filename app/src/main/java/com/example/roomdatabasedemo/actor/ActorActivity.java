package com.example.roomdatabasedemo.actor;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabasedemo.R;
import com.example.roomdatabasedemo.rest.RetrofitClient;
import com.example.roomdatabasedemo.room.ModelRepository;
import com.example.roomdatabasedemo.room.ObjectViewModel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ModelRepository modelRepository;
    private ObjectViewModel viewModel;
    private List<Actor> actorList;
    private ActorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);

        recyclerView=findViewById(R.id.actor_recycler);
        actorList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //recyclerView.setAdapter(adapter);

        adapter = new ActorAdapter(actorList, this);
        modelRepository = new ModelRepository(getApplication());
        viewModel = new ViewModelProvider(this).get(ObjectViewModel.class);

        viewModel.getActorList().observe(this, actors -> {
                    adapter.getAllActors(actorList);
                    recyclerView.setAdapter(adapter);
                    Log.d("main","onChanged"+actorList);

                }
        );





        Call<List<Actor>> call = RetrofitClient.getInstance().getApi().GetActorDetails();
        call.enqueue(new Callback<List<Actor>>() {
            @Override
            public void onResponse(Call<List<Actor>> call, Response<List<Actor>> response) {
                if (response.isSuccessful()) {
                    modelRepository.InsertActors(response.body());
                } else {
                    Toast.makeText(ActorActivity.this, response.code() + " - " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Actor>> call, Throwable t) {
                Toast.makeText(ActorActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}