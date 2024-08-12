/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.view.ViewGroup
 *  androidx.viewpager.widget.PagerAdapter
 *  com.qmuiteam.qmui.widget.QMUIPagerAdapter$Action
 */
package com.qmuiteam.qmui.widget;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.qmuiteam.qmui.widget.QMUIPagerAdapter;

public abstract class QMUIPagerAdapter
extends PagerAdapter {
    private SparseArray<Object> mScrapItems = new SparseArray();

    protected abstract void destroy(ViewGroup var1, int var2, Object var3);

    public final void destroyItem(ViewGroup viewGroup, int n, Object object) {
        this.destroy(viewGroup, n, object);
    }

    public void each(Action action) {
        int n = this.mScrapItems.size();
        int n2 = 0;
        while (n2 < n) {
            if (action.call((Object)this.mScrapItems.indexOfValue((Object)n2))) {
                return;
            }
            ++n2;
        }
    }

    protected abstract Object hydrate(ViewGroup var1, int var2);

    public final Object instantiateItem(ViewGroup viewGroup, int n) {
        Object object;
        Object object2 = object = this.mScrapItems.get(n);
        if (object == null) {
            object2 = this.hydrate(viewGroup, n);
            this.mScrapItems.put(n, object2);
        }
        this.populate(viewGroup, object2, n);
        return object2;
    }

    protected abstract void populate(ViewGroup var1, Object var2, int var3);
}
