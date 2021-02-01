package com.koreait.scaduleapp.animation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    Fragment[] fragments = new Fragment[5];

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        fragments[0] =new AlphaFragment();
        fragments[1] =new ScaleFragment();
        fragments[2] =new TranslateFragment();
        fragments[3] =new RotateFragment();
        fragments[4] =new SetFragment();
    }

    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {

        return fragments.length;
    }
}
