/**
 * @Author: Yizhao He & Jiutian Zhang
 *
 *  Modified to extend OrderedListActivity
 *  @Auther James(Yizhao) He @ Jiutian Zhang
 */
package com.csci3130.project.team1;
import android.os.Bundle;


public class CannabisDateOrderedListActivity extends OrderedListActivity {
    @Override
    public Product setProduct() {
        return Product.CANNABIS;
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


