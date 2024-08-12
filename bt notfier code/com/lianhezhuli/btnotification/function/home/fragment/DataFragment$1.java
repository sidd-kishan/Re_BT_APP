/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentStatePagerAdapter
 *  com.lianhezhuli.btnotification.function.home.fragment.DataFragment
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.lianhezhuli.btnotification.function.home.fragment.DataFragment;

/*
 * Exception performing whole class analysis ignored.
 */
class DataFragment.1
extends FragmentStatePagerAdapter {
    final DataFragment this$0;

    DataFragment.1(DataFragment dataFragment, FragmentManager fragmentManager) {
        this.this$0 = dataFragment;
        super(fragmentManager);
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        super.destroyItem(viewGroup, n, object);
    }

    public int getCount() {
        return DataFragment.access$000((DataFragment)this.this$0).size();
    }

    public Fragment getItem(int n) {
        return (Fragment)DataFragment.access$000((DataFragment)this.this$0).get(n);
    }
}
