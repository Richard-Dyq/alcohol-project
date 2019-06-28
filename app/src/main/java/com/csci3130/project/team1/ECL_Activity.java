package com.csci3130.project.team1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ECL_Activity extends AppCompatActivity {
    EditText input;
    Button submitButton;
    Button backButton;
    TextView output;
    FirebaseFirestore database;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecl);

        input = (EditText) findViewById(R.id.inputLevel);
        submitButton = (Button) findViewById(R.id.button_sub);
        backButton = findViewById(R.id.back);
        output = (TextView) findViewById(R.id.message);
        database = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        setupUI();

    }
    /**
     * author Ganrong Tan & Jiutian Zhang
     * @param uid userId for specific data node
     * @param c_level cannabis daily intake level
     * @param date upload day
     * date Sun June 16 2019
     */
    public void uploadData(final String uid, final double c_level, Date date) {
        final DocumentReference ref = database
                .collection("users")
                .document(uid)
                .collection("cannabis")
                .document();
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("c_level", c_level);
        inputData.put("date", date);
        ref.set(inputData);
    }


    private void setupUI(){
        /**
         * Read in a input number (must bigger than 0)as the cannabis intake,
         * then based on the value returns a message that inform
         * user if his/her intake is too much.
         * 0-20 -> safe, 20-40 -> moderate, 40-60 -> excess, 60-80 -> danger
         * 80+ -> very danger
         */

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double intake = Double.valueOf(input.getText().toString());
                if (intake > 80)
                    output.setText("Your intake is very danger\nplease consider emergency measures");
                else if (intake > 60 && intake <= 80)
                    output.setText("Your intake is danger");
                else if (intake > 40 && intake <= 60)
                    output.setText("Your intake is excess");
                else if (intake > 20 && intake <= 40)
                    output.setText("Your intake is moderate");
                else if (intake > 0 && intake <= 20)
                    output.setText("Your intake is safe");
                else if (intake <= 0)
                    output.setText("Please input a positive number");
                else
                    output.setText("Please input a number of your intake");

                FirebaseUser currentUser = mAuth.getCurrentUser();

                String uid = currentUser.getUid();
                uploadData(uid, intake, new Date());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}