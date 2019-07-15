package com.csci3130.project.team1;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csci3130.project.team1.model.AlcoholProduct;
import com.csci3130.project.team1.viewHolder.AlcoholProductViewHolder;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AlcoholProductListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FirebaseFirestore database;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerView = findViewById(R.id.product_list);
        database = FirebaseFirestore.getInstance();

        adapter = setUpAdapter(database);
        setUpRecyclerView(recyclerView,adapter);


    }

    //Connects our recycler view with the viewholder (how we want to show our model[data])
    // and the firestore adapter
    private void setUpRecyclerView(RecyclerView rv, FirestoreRecyclerAdapter adapter)
    {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(manager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
    }


    //Creates a Firestore adapter to be used with a Recycler view.
    //We will see adapter in more details after the midterm
    //More info on this: https://github.com/firebase/FirebaseUI-Android/blob/master/firestore/README.md
    private FirestoreRecyclerAdapter setUpAdapter(FirebaseFirestore db)
    {
        Query query = db.collection("Alcohol").orderBy("name").limit(50);
        FirestoreRecyclerOptions<AlcoholProduct> options = new FirestoreRecyclerOptions.Builder<AlcoholProduct>()
                .setQuery(query,AlcoholProduct.class)
                .build();

        FirestoreRecyclerAdapter adapter = new FirestoreRecyclerAdapter<AlcoholProduct,AlcoholProductViewHolder>(options)
        {
            //For each item in the database connect it to the view
            @Override
            public void onBindViewHolder(final AlcoholProductViewHolder holder, int position, final AlcoholProduct model)
            {
                holder.title.setText(model.getName());
                holder.type.setText("Type: " + model.getTypeLiteral());
                holder.level.setText("Level: " + model.getLevel());
                Picasso.get().load(model.getUrl()).into(holder.imageView);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("22");
                    }
                });
            }

            @Override
            public AlcoholProductViewHolder onCreateViewHolder(ViewGroup group, int i)
            {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.product,group,false);
                return new AlcoholProductViewHolder(view);

            }
        };

        return adapter;

    }




    //Method called every time the activity starts.
    @Override
    protected void onStart() {
        super.onStart();
        //Tells the adapter to start listening for changes in the database
        adapter.startListening();
    }

    //Method called every time the activity stops
    @Override
    protected void onStop() {
        super.onStop();
        //Tells the adapter to stop listening since we are not using this activity
        //  anymore. Otherwise the adapter would still exist in the background draining battery
        //  with useful cycles...
        adapter.stopListening();
    }
}
