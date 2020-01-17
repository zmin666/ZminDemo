package com.example.zmindemo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author: ZhangMin
 * @date: 2019/11/18 14:56
 * @version: 1.0
 * @desc:
 */
public class MineAdapter extends FragmentPagerAdapter {

    List<Fragment>  mPages;
    public MineAdapter(FragmentManager fm, List<Fragment> pages) {
        super(fm);
        mPages=pages;
    }

    @Override
    public Fragment getItem(int i) {
        return mPages.get(i);
    }

    @Override
    public int getCount() {
        return mPages.size();
    }
}
