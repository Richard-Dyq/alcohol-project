package com.csci3130.project.team1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.csci3130.project.team1.model.AlcoholProduct;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * @Author: Yuqiao Du & Ganrong Tang
 */

public class AlcoholDetailActivity extends AppCompatActivity {

    private TextView brand;
    private TextView alcoholamount;
    private TextView type;
    private TextView description;

    private FirebaseFirestore database;
    private Intent intent;
    private AlcoholProduct product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcoholdetail);

        brand = findViewById(R.id.brand1);
        alcoholamount = findViewById(R.id.AA);
        type = findViewById(R.id.type1);
        description = findViewById(R.id.description1);

        database = FirebaseFirestore.getInstance();

        intent = getIntent();
        product = (AlcoholProduct)intent.getSerializableExtra("product");
        brand.setText(product.getName());
        alcoholamount.setText("Level:" + product.getLevel());
        type.setText(product.getTypeLiteral());
        description.setText(product.getDescription());
    }
}
