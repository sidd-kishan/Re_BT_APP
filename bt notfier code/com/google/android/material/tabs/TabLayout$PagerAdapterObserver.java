/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  com.google.android.material.tabs.TabLayout
 */
package com.google.android.material.tabs;

import android.database.DataSetObserver;
import com.google.android.material.tabs.TabLayout;

private class TabLayout.PagerAdapterObserver
extends DataSetObserver {
    final TabLayout this$0;

    TabLayout.PagerAdapterObserver(TabLayout tabLayout) {
        this.this$0 = tabLayout;
    }

    public void onChanged() {
        this.this$0.populateFromPagerAdapter();
    }

    public void onInvalidated() {
        this.this$0.populateFromPagerAdapter();
    }
}
