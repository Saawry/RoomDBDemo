package com.example.roomdatabasedemo.students;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.roomdatabasedemo.R;
import com.example.roomdatabasedemo.rest.RetrofitClient;
import com.example.roomdatabasedemo.room.ObjectViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllStudentsInfo extends AppCompatActivity {

    private ObjectViewModel objectViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_students_info);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final StudentAdapter adapter = new StudentAdapter();
        recyclerView.setAdapter(adapter);


        objectViewModel = ViewModelProviders.of(this).get(ObjectViewModel.class);
        objectViewModel.getAllStudents().observe(this, studentsInfo -> adapter.setStudents(studentsInfo));

        Call<AllStudentsResponse> call = RetrofitClient.getInstance().getApi().GetAllStudentDetails();
        call.enqueue(new Callback<AllStudentsResponse>() {
            @Override
            public void onResponse(Call<AllStudentsResponse> call, Response<AllStudentsResponse> response) {
                if (response.isSuccessful()) {


                } else {
                    Toast.makeText(AllStudentsInfo.this, response.code() + " - " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllStudentsResponse> call, Throwable t) {
                Toast.makeText(AllStudentsInfo.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}