package com.csci3130.project.team1.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.csci3130.project.team1.R;

public class CannabisProductViewHolder extends RecyclerView.ViewHolder  {
    public TextView THC;
    public TextView title;
    public TextView type;
    public ImageView imageView;

    public CannabisProductViewHolder(View view)
    {
        super(view);
        THC = view.findViewById(R.id.product_level);
        title = view.findViewById(R.id.product_title);
        type = view.findViewById(R.id.product_type);
        imageView = view.findViewById(R.id.product_imageView);
    }
}
