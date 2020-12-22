package com.example.roomdatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabasedemo.rest.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewStudentDetails extends AppCompatActivity {

    private EditText studentIdEt;
    private Button viewBtn;
    private TextView studentDetailsTv;
    private String stdId;
    private StudentInfo studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_details);

        studentIdEt.findViewById(R.id.student_details_id);
        viewBtn.findViewById(R.id.Student_details_btn);
        studentDetailsTv.findViewById(R.id.student_details_tv);

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stdId = studentIdEt.getText().toString();
                if (!stdId.isEmpty()) {
                    RetrieveDetails();
                } else {
                    Toast.makeText(ViewStudentDetails.this, "Enter ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void RetrieveDetails() {
        Call<StudentDetailsResponse> call = RetrofitClient.getInstance().getApi().GetStudentDetails(stdId);
        call.enqueue(new Callback<StudentDetailsResponse>() {
            @Override
            public void onResponse(Call<StudentDetailsResponse> call, Response<StudentDetailsResponse> response) {
                if (response.isSuccessful()) {
                    studentInfo = response.body().getData();
                    studentDetailsTv.setVisibility(View.VISIBLE);
                    studentDetailsTv.setText(studentInfo.toString());

                } else {
                    Toast.makeText(ViewStudentDetails.this, response.code() + " - " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StudentDetailsResponse> call, Throwable t) {
                Toast.makeText(ViewStudentDetails.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}