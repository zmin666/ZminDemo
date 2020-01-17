package com.example.zmindemo;

import android.os.Bundle;

/**
 * @author: ZhangMin
 * @date: 2019/11/18 15:00
 * @version: 1.0
 * @desc:
 */
public class SimpleFragment extends BaseAppearFragment {

    public static SimpleFragment newInstance(int page) {
        SimpleFragment simpleFragment = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", page);
        simpleFragment.setArguments(bundle);
        return simpleFragment;
    }

//
//    @Override
//    protected void lazyInit() {
//        super.lazyInit();
//    }
}
