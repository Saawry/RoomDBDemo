package com.example.roomdatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabasedemo.rest.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStudent extends AppCompatActivity {

    private String Id,studentId,studentRoll,admissionDate,DateOfBirth,ShiftId,classId,
            sectionId,imageName,createdTime,createdBy,status,Guardian_Phone,Relation;

    private Button addStudentBtn;

    private EditText studentIdEt,studentRollEt, ShiftIdEt,classIdEt,sectionIdEt,
            createdByEt,statusEt,Guardian_PhoneEt,RelationEt;

    private EditText admissionDateEt,DateOfBirthEt,imageNameEt,createdTimeEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        InitializeVariables();
        GetData();

        addStudentBtn.setOnClickListener(view -> {
            InsertNewStudent();
            //VerifyAndSubmit
        });

    }

    private void InsertNewStudent() {
        Call<Dflt> call = RetrofitClient.getInstance().getApi().AddNewStudent(stdDetails);
        call.enqueue(new Callback<Dflt>() {
            @Override
            public void onResponse(Call<Dflt> call, Response<Dflt> response) {
                if (response.isSuccessful()) {
                    //String msg = response.body();

                } else {
                    Toast.makeText(AddStudent.this, response.code() + " - " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Dflt> call, Throwable t) {
                Toast.makeText(AddStudent.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void InitializeVariables() {

        addStudentBtn=findViewById(R.id.Student_add_btn);

        studentIdEt=findViewById(R.id.student_id_add);
        studentRollEt=findViewById(R.id.student_roll_add);
        ShiftIdEt=findViewById(R.id.student_shift_id_add);
        classIdEt=findViewById(R.id.student_class_id_add);
        sectionIdEt=findViewById(R.id.student_section_id_add);
        createdByEt=findViewById(R.id.student_created_by_add);
        statusEt=findViewById(R.id.student_status_add);
        Guardian_PhoneEt=findViewById(R.id.student_guardian_phone_add);
        RelationEt=findViewById(R.id.student_relation_add);

        admissionDateEt=findViewById(R.id.student_admission_date_add);
        DateOfBirthEt=findViewById(R.id.student_birth_date_add);
        imageNameEt=findViewById(R.id.student_image_url_add);
        createdTimeEt=findViewById(R.id.student_created_time_add);
    }
    private void GetData() {

        studentId=studentIdEt.getText().toString();
        studentRoll=studentRollEt.getText().toString();
        ShiftId=ShiftIdEt.getText().toString();
        classId=classIdEt.getText().toString();
        sectionId=sectionIdEt.getText().toString();
        createdBy=createdByEt.getText().toString();
        status=statusEt.getText().toString();
        Guardian_Phone=Guardian_PhoneEt.getText().toString();
        Relation=RelationEt.getText().toString();

        admissionDate=admissionDateEt.getText().toString();
        DateOfBirth=DateOfBirthEt.getText().toString();
        imageName=imageNameEt.getText().toString();
        createdTime=createdTimeEt.getText().toString();
    }
}