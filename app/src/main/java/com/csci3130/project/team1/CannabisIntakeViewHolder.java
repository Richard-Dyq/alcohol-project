/**
 * @Author: Yizhao He & Jiutian Zhang
 */
package com.csci3130.project.team1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CannabisIntakeViewHolder extends RecyclerView.ViewHolder  {
    public TextView level;
    public TextView date;

    /**
     * set up the ViewHolder
     * @param view View object
     */
    public CannabisIntakeViewHolder(View view)
    {
        super(view);
        level = view.findViewById(R.id.level);
        date = view.findViewById(R.id.date);
    }
}
