package com.example.roomdatabasedemo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE =
            "com.example.roomdatabasedemo.EXTRA_TITLE";
    public static final String EXTRA_PRICE =
            "com.example.roomdatabasedemo.EXTRA_PRICE";
    private EditText etTitle, etPrice;
    private Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        etPrice= findViewById(R.id.product_add_price);
        etTitle= findViewById(R.id.product_add_title);

        btnAdd= findViewById(R.id.product_add_btn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String price = etPrice.getText().toString();

                if (title.trim().isEmpty()) {
                    Toast.makeText(AddProductActivity.this, "Please insert a title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (price.trim().isEmpty()) {
                    Toast.makeText(AddProductActivity.this, "Please insert a description", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent data = new Intent();
                data.putExtra(EXTRA_TITLE, title);
                data.putExtra(EXTRA_PRICE, price);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}