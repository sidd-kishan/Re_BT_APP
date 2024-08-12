/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  androidx.viewpager.widget.ViewPager
 */
package androidx.viewpager.widget;

import android.database.DataSetObserver;
import androidx.viewpager.widget.ViewPager;

private class ViewPager.PagerObserver
extends DataSetObserver {
    final ViewPager this$0;

    ViewPager.PagerObserver(ViewPager viewPager) {
        this.this$0 = viewPager;
    }

    public void onChanged() {
        this.this$0.dataSetChanged();
    }

    public void onInvalidated() {
        this.this$0.dataSetChanged();
    }
}
