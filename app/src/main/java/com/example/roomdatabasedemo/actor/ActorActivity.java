package com.example.roomdatabasedemo.actor;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabasedemo.R;
import com.example.roomdatabasedemo.rest.RetrofitClient;
import com.example.roomdatabasedemo.room.ModelRepository;
import com.example.roomdatabasedemo.room.ObjectViewModel;
import com.example.roomdatabasedemo.students.AllStudentsInfo;
import com.example.roomdatabasedemo.students.AllStudentsResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActorActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn;
    private ObjectViewModel objectViewModel;
    private ModelRepository modelRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);

        tv=findViewById(R.id.actor_details_tv);
        btn=findViewById(R.id.button_actor);
        modelRepository=new ModelRepository(getApplication());

        objectViewModel = ViewModelProviders.of(this).get(ObjectViewModel.class);
        //objectViewModel.getAllActors().observe(this,actors -> );

        final Observer<List<Actor>> ActorObserver = NewActor -> {
            // Update the UI, in this case, a TextView.
            tv.setText(NewActor.toString());
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        objectViewModel.getAllActors().observe(this, ActorObserver);
        //objectViewModel.getAllStudents().observe(this, studentsInfo -> adapter.setStudents(studentsInfo));

//        Call<ActorResponse> call = RetrofitClient.getInstance().getApi().GetActorDetails();
//        call.enqueue(new Callback<ActorResponse>() {
//            @Override
//            public void onResponse(Call<ActorResponse> call, Response<ActorResponse> response) {
//                if (response.isSuccessful()) {
//
//                    tv.setText(response.body().toString());
//
//                    //modelRepository.InsertAllActors(response.body().getActors());
//                    //tv.setText(response.body().getActors().toString());
////                    List<StudentInfo> studentList;
////                    studentList=response.body().getStudentInfoList();
////                    adapter.setStudents(studentList);
//                } else {
//                    Toast.makeText(ActorActivity.this, response.code() + " - " + response.message(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ActorResponse> call, Throwable t) {
//                Toast.makeText(ActorActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });



        Call<List<Actor>> call = RetrofitClient.getInstance().getApi().GetActorDetails();
        call.enqueue(new Callback<List<Actor>>() {
            @Override
            public void onResponse(Call<List<Actor>> call, Response<List<Actor>> response) {
                if (response.isSuccessful()) {

                    tv.setText(response.message());
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