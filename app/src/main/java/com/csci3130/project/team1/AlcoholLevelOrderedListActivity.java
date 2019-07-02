/**
 * @Author: Ganrong Tan & Zixuan Liu
 * @Date: 30 June, 2019
 */

package com.csci3130.project.team1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class AlcoholLevelOrderedListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private FirebaseFirestore database;
    private FirestoreRecyclerAdapter adapter;

    /**
     *
     * @Author: Ganrong Tan & Zixuan Liu
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol_level_ordered_list);

        recyclerView = findViewById(R.id.cannabisList);
        database = FirebaseFirestore.getInstance();

        adapter = setUpAdapter(database);
        setUpRecyclerView(recyclerView,adapter);

    }


    /**
     * @Author: Ganrong Tan & Zixuan Liu
     * @param rv
     * @param adapter
     */
    private void setUpRecyclerView(RecyclerView rv, FirestoreRecyclerAdapter adapter)
    {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(manager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
    }

    /**
     * @Author: Ganrong Tan & Zixuan Liu
     * @param db
     * @return
     */
    private FirestoreRecyclerAdapter setUpAdapter(FirebaseFirestore db)
    {

        String uid = "FasbrbwjDDYvjGDzQ9cRZB88Aqn2";
        Query query = db.collection("users").document(uid).collection("alcohol").orderBy("a_level").limit(50);
        FirestoreRecyclerOptions<AlcoholIntake> options = new FirestoreRecyclerOptions.Builder<AlcoholIntake>()
                .setQuery(query, AlcoholIntake.class)
                .build();

        FirestoreRecyclerAdapter adapter = new FirestoreRecyclerAdapter<AlcoholIntake, AlcoholIntakeViewHolder>(options)
        {
            //For each item in the database connect it to the view
            @Override
            public void onBindViewHolder(AlcoholIntakeViewHolder holder, int position, final AlcoholIntake model)
            {
                System.out.println(model);
                holder.level.setText(model.getALevel_Literial());
                holder.date.setText(model.getDate_Literial());
            }

            @Override
            public AlcoholIntakeViewHolder onCreateViewHolder(ViewGroup group, int i)
            {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.data_entry,group,false);
                return new AlcoholIntakeViewHolder(view);

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
