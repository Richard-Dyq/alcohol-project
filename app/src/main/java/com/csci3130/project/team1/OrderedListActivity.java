/**
 *
 * This Class is for providing FirebaseRecyclerAdapter for Cannabis and Alcohol
 * ordered by level and date.
 *
 * @Author Yizhao He & Jiutian Zhang
 */

package com.csci3130.project.team1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csci3130.project.team1.model.AlcoholIntake;
import com.csci3130.project.team1.model.CannabisIntake;
import com.csci3130.project.team1.viewHolder.AlcoholIntakeViewHolder;
import com.csci3130.project.team1.viewHolder.CannabisIntakeViewHolder;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public abstract class OrderedListActivity extends AppCompatActivity {

    public enum Product {
        CANNABIS,
        ALHOCOL
    }
    public enum OrderBy{
        LEVEL,
        DATE
    }

    private RecyclerView recyclerView;
    private FirebaseFirestore database;
    private FirestoreRecyclerAdapter adapter;
    private Product product;
    private OrderBy orderBy;

    //Delegate
    public abstract Product setProduct();
    public abstract OrderBy setOrderBy();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        product = setProduct();
        orderBy = setOrderBy();

        setContentView(R.layout.activity_cannabis_date_ordered_list);
        recyclerView = findViewById(R.id.cannabisList);
        database = FirebaseFirestore.getInstance();
        adapter = setUpAdapter(database);
        setUpRecyclerView(recyclerView,adapter);
    }




    /**
     *  this method creates a recycler list to display the cannabis
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

    /**
     *  this method creates a recycler list to display the cannabis
     * @param db
     * @return
     */
    public FirestoreRecyclerAdapter setUpAdapter(FirebaseFirestore db){
        String uid = getUid();

        return generateQueryAndSetupAdapter(uid);
    }


    /**
     * Generate corresponding query according to uid and delegation value.
     *
     * @param uid
     * @return Firebase Query Object
     */
    private FirestoreRecyclerAdapter generateQueryAndSetupAdapter(String uid){
        FirestoreRecyclerAdapter adapter;
        switch (product){
            case ALHOCOL:
                adapter = generateAlcoholQueryAndSetupAdapter(uid);
                break;
            case CANNABIS:
                adapter = generateCannabisQueryAndSetupAdapter(uid);
                break;
            default:
                throw new IllegalArgumentException("Invalid Product");
        }

        return adapter;
    }

    /**
     * generate Alcohol Query Ordered by Level or Date
     *
     * @param uid
     * @return Firebase Query Object
     */
    private FirestoreRecyclerAdapter generateAlcoholQueryAndSetupAdapter(String uid){
        Query query;
        switch (orderBy){
            case DATE:
                query = database
                        .collection("users")
                        .document(uid)
                        .collection("alcohol")
                        .orderBy("date").limit(50);
                break;
            case LEVEL:
                query = database
                        .collection("users")
                        .document(uid)
                        .collection("alcohol")
                        .orderBy("a_level").limit(50);
                break;
            default:
                throw new IllegalArgumentException("Invalid OrderBy Key");
        }

        FirestoreRecyclerOptions<AlcoholIntake> options = new FirestoreRecyclerOptions.Builder<AlcoholIntake>()
                .setQuery(query,AlcoholIntake.class)
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

    /**
     * generate Cannabis Query Ordered by Level or Date
     * @param uid
     * @return Firebase Query Object
     */
    private FirestoreRecyclerAdapter generateCannabisQueryAndSetupAdapter(String uid){
        Query query;
        switch (orderBy){
            case DATE:
                query = database
                        .collection("users")
                        .document(uid)
                        .collection("cannabis")
                        .orderBy("date").limit(50);
                break;
            case LEVEL:
                query = database
                        .collection("users")
                        .document(uid)
                        .collection("cannabis")
                        .orderBy("c_level").limit(50);
                break;
            default:
                throw new IllegalArgumentException("Invalid OrderBy Key");
        }

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
