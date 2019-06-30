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

/*
This class give the Cannbis list sorted by level
@Yuqiao Du & Zihao Liu
 */
public class CannabisLevelOrderedListActivity extends AppCompatActivity {

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

/*
    this method creates a recycler list to display the cannabis
    @param recyclerview
    @param FirestoreRecyclerAdapte adapter
    @retuen void
 */
    private void setUpRecyclerView(RecyclerView rv, FirestoreRecyclerAdapter adapter)
    {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(manager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
    }
    /*
        this method gets uid
        @retuen String
     */
    public String getUid(){
        String uid = "";
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
            uid = user.getUid();
        return uid;
    }
    /*
        this method creates a recycler list to display the cannabis
        @param FirebaseFirestore
        @retuen adapter
     */
    public FirestoreRecyclerAdapter setUpAdapter(FirebaseFirestore db){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String uid = user.getUid();

        Query query = db.collection("users").document(uid).collection("cannabis").orderBy("c_level").limit(50);
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


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
