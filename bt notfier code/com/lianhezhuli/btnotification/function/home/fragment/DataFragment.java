/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.Fragment
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  butterknife.BindView
 *  com.lianhezhuli.btnotification.base.BaseFragment
 *  com.lianhezhuli.btnotification.function.home.fragment.data.DataSleepFragment
 *  com.lianhezhuli.btnotification.function.home.fragment.data.DataSportFragment
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.lianhezhuli.btnotification.base.BaseFragment;
import com.lianhezhuli.btnotification.function.home.fragment.data.DataSleepFragment;
import com.lianhezhuli.btnotification.function.home.fragment.data.DataSportFragment;
import java.util.ArrayList;
import java.util.List;

public class DataFragment
extends BaseFragment {
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    @BindView(value=2131296437)
    ViewPager mViewPager;

    static /* synthetic */ List access$000(DataFragment dataFragment) {
        return dataFragment.mFragments;
    }

    private void initViewPager() {
        this.mViewPager.setAdapter((PagerAdapter)new /* Unavailable Anonymous Inner Class!! */);
    }

    protected int getLayoutId() {
        return 2131492924;
    }

    protected void initView() {
        this.mFragments.add((Fragment)new DataSportFragment());
        this.mFragments.add((Fragment)new DataSleepFragment());
        this.initViewPager();
    }
}
