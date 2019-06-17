package com.csci3130.project.team1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Upload extends AppCompatActivity {
    FirebaseFirestore database = FirebaseFirestore.getInstance();

    /**
     * author Ganrong Tan & Jiutian Zhang
     * @param uid userId for specific data node
     * @param c_level cannabis daily intake level
     * @param date upload day
     * date Sun June 16 2019
     */
    public void uploadData(final String uid, final double c_level, Date date) {
        final DocumentReference ref = database.collection("users").document(uid);
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("c_level", c_level);
        inputData.put("date", date);
        ref.set(inputData);
    }

}