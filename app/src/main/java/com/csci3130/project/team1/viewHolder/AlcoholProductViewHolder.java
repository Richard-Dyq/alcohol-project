package com.csci3130.project.team1.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.csci3130.project.team1.R;

public class AlcoholProductViewHolder extends RecyclerView.ViewHolder  {
    public TextView level;
    public TextView title;
    public TextView type;
    public ImageView imageView;

    public AlcoholProductViewHolder(View view)
    {
        super(view);
        level = view.findViewById(R.id.product_level);
        title = view.findViewById(R.id.product_title);
        type = view.findViewById(R.id.product_type);
        imageView = view.findViewById(R.id.product_imageView);
    }
}
