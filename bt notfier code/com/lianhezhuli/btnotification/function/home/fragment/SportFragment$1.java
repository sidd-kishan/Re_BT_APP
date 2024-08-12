/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.viewpager.widget.PagerAdapter
 *  com.lianhezhuli.btnotification.function.home.fragment.SportFragment
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.lianhezhuli.btnotification.function.home.fragment.SportFragment;

/*
 * Exception performing whole class analysis ignored.
 */
class SportFragment.1
extends PagerAdapter {
    final SportFragment this$0;

    SportFragment.1(SportFragment sportFragment) {
        this.this$0 = sportFragment;
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        viewGroup.removeView((View)SportFragment.access$000((SportFragment)this.this$0).get(n));
    }

    public int getCount() {
        return SportFragment.access$000((SportFragment)this.this$0).size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int n) {
        View view = (View)SportFragment.access$000((SportFragment)this.this$0).get(n);
        viewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean bl = view == object;
        return bl;
    }
}
