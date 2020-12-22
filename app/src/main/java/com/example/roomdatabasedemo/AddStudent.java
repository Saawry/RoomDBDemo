package com.example.roomdatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddStudent extends AppCompatActivity {

    private EditText IdEt,studentIdEt,studentRollEt,admissionDateEt,DateOfBirthEt,
            ShiftIdEt,classIdEt,sectionIdEt,imageNameEt,createdTimeEt,createdByEt,
            statusEt,Guardian_PhoneEt,RelationEt;
    private String Id,studentId,studentRoll,admissionDate,DateOfBirth,ShiftId,classId,
            sectionId,imageName,createdTime,createdBy,status,Guardian_Phone,Relation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
    }
}