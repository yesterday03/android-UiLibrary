package com.killua.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2Adapter extends FragmentStateAdapter {

    private Fragment[] mFragments;

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity, Fragment[] mFragments) {
        super(fragmentActivity);
        this.mFragments = mFragments;
    }

    public ViewPager2Adapter(@NonNull Fragment fragment) {
        super(fragment);
        this.mFragments = mFragments;
    }

    public ViewPager2Adapter(@NonNull Fragment fragment, Fragment[] mFragments) {
        super(fragment);
        this.mFragments = mFragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragments!=null?mFragments[position]:null;
    }

    @Override
    public long getItemId(int position) {
        return mFragments[position].hashCode();
    }

    @Override
    public int getItemCount() {
        return mFragments!=null?mFragments.length:0;
    }

    public void setmFragments(Fragment[] mFragments) {
        this.mFragments = mFragments;
    }
}
