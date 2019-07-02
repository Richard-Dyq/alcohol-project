/**
 This class give the Cannbis list sorted by level
 @Auther Yuqiao Du & Zihao Liu

 Modified to extend OrderedListActivity
 @Auther James(Yizhao) He @ Jiutian Zhang
 */

package com.csci3130.project.team1;

import android.os.Bundle;

public class CannabisLevelOrderedListActivity extends OrderedListActivity {
    @Override
    public Product setProduct() {
        return Product.CANNABIS;
    }

    @Override
    public OrderBy setOrderBy() {
        return OrderBy.LEVEL;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
