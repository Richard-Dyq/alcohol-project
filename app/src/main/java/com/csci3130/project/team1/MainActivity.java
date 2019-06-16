/**
 * author Ganrong Tan & Jiutian Zhang
 * date Sun June 16 2019
 */
package com.csci3130.project.team1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.Timestamp;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Upload update = new Upload();
        update.uploadData("MZOazYE4B3fm70PSiXAq", 20.0, new Date());
    }


}
