package com.csci3130.project.team1;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Logout extends AppCompatActivity{
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);

        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logout.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(Logout.this, "Successfully logout", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

