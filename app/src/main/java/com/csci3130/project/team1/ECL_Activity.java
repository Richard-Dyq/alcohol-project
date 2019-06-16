package com.csci3130.project.team1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ECL_Activity extends AppCompatActivity {
    EditText input;
    Button button;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecl);

        input = (EditText) findViewById(R.id.inputLevel);
        button = (Button) findViewById(R.id.button_sub);
        output = (TextView) findViewById(R.id.message);

        /**
         * Read in a input number (must bigger than 0)as the cannabis intake,
         * then based on the value returns a message that inform
         * user if his/her intake is too much.
         * 0-20 -> safe, 20-40 -> moderate, 40-60 -> excess, 60-80 -> danger
         * 80+ -> very danger
         */

        button.setOnClickListener(new View.OnClickListener() {
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
            }
        });

    }
}