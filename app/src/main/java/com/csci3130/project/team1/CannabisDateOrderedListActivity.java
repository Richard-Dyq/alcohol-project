/**
 * @Author: Yizhao He & Jiutian Zhang
 */
package com.csci3130.project.team1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class CannabisDateOrderedListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private FirebaseFirestore database;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannabis_date_ordered_list);

        recyclerView = findViewById(R.id.cannabisList);
        database = FirebaseFirestore.getInstance();

        adapter = setUpAdapter(database);
        setUpRecyclerView(recyclerView,adapter);

    }

    /**
     * the method to set up the RecyclerView
     * @param rv RecyclerView
     * @param adapter FirestoreRecyclerAdapter
     */
    private void setUpRecyclerView(RecyclerView rv, FirestoreRecyclerAdapter adapter)
    {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(manager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
    }

    /**
     * to get the user's id
     * @return user id
     */
    public String getUid(){
        String uid = "";
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
            uid = user.getUid();
        return uid;
    }

    /**
     * to show all the cannabis level and date
     * @param db Firebase database
     * @return FirestoreRecyclerAdapter
     */
    public FirestoreRecyclerAdapter setUpAdapter(FirebaseFirestore db){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String uid = user.getUid();

        Query query = db.collection("users").document(uid).collection("cannabis").orderBy("date").limit(50);
        FirestoreRecyclerOptions<CannabisIntake> options = new FirestoreRecyclerOptions.Builder<CannabisIntake>()
                .setQuery(query,CannabisIntake.class)
                .build();

        FirestoreRecyclerAdapter adapter = new FirestoreRecyclerAdapter<CannabisIntake,CannabisIntakeViewHolder>(options)
        {
            //For each item in the database connect it to the view
            @Override
            public void onBindViewHolder(CannabisIntakeViewHolder holder, int position, final CannabisIntake model)
            {
                System.out.println(model);
                holder.level.setText(model.getC_level_Literal());
                holder.date.setText(model.getDate_literal());
            }

            @Override
            public CannabisIntakeViewHolder onCreateViewHolder(ViewGroup group, int i)
            {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.data_entry,group,false);
                return new CannabisIntakeViewHolder(view);

            }
        };
        return adapter;
    }

    /**
     * start listener
     */
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    /**
     * stop listener
     */
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
