/**
 * @Author: Ganrong Tan & Zixuan Liu
 * @Date: 30 June, 2019
 *
 *  Modified to extend OrderedListActivity
 *  @Auther James(Yizhao) He @ Jiutian Zhang
 */
package com.csci3130.project.team1;
import android.os.Bundle;


public class AlcoholDateOrderedListActivity extends OrderedListActivity {
    @Override
    public Product setProduct() {
        return Product.ALHOCOL;
    }

    @Override
    public OrderBy setOrderBy() {
        return OrderBy.DATE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
