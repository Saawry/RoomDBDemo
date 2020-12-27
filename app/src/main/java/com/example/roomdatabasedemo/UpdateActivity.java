package com.example.roomdatabasedemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    private EditText etTitle, etPrice;
    private Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etPrice= findViewById(R.id.product_add_price);
        etTitle= findViewById(R.id.product_add_title);

        btnUpdate= findViewById(R.id.product_add_btn);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}