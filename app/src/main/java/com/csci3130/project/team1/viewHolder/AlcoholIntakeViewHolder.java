package com.csci3130.project.team1.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.csci3130.project.team1.R;

public class AlcoholIntakeViewHolder extends RecyclerView.ViewHolder  {
    public TextView level;
    public TextView date;

    public AlcoholIntakeViewHolder(View view)
    {
        super(view);
        level = view.findViewById(R.id.level);
        date = view.findViewById(R.id.date);
    }
}
