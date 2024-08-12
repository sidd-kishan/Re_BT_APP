/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.viewpager.widget.ViewPager
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.home.fragment.DataFragment
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.home.fragment.DataFragment;

public class DataFragment_ViewBinding
implements Unbinder {
    private DataFragment target;

    public DataFragment_ViewBinding(DataFragment dataFragment, View view) {
        this.target = dataFragment;
        dataFragment.mViewPager = (ViewPager)Utils.findRequiredViewAsType((View)view, (int)2131296437, (String)"field 'mViewPager'", ViewPager.class);
    }

    public void unbind() {
        DataFragment dataFragment = this.target;
        if (dataFragment == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        dataFragment.mViewPager = null;
    }
}
