/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.viewpager.widget.PagerAdapter
 *  com.qmuiteam.qmui.widget.QMUIPagerAdapter
 *  com.qmuiteam.qmui.widget.QMUIViewPager
 */
package com.qmuiteam.qmui.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.qmuiteam.qmui.widget.QMUIPagerAdapter;
import com.qmuiteam.qmui.widget.QMUIViewPager;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIViewPager.WrapperPagerAdapter
extends PagerAdapter {
    private QMUIPagerAdapter mAdapter;
    final QMUIViewPager this$0;

    public QMUIViewPager.WrapperPagerAdapter(QMUIViewPager qMUIViewPager, QMUIPagerAdapter qMUIPagerAdapter) {
        this.this$0 = qMUIViewPager;
        this.mAdapter = qMUIPagerAdapter;
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        int n2 = n;
        if (QMUIViewPager.access$000((QMUIViewPager)this.this$0)) {
            n2 = n;
            if (this.mAdapter.getCount() != 0) {
                n2 = n % this.mAdapter.getCount();
            }
        }
        this.mAdapter.destroyItem(viewGroup, n2, object);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        this.mAdapter.finishUpdate(viewGroup);
    }

    public int getCount() {
        int n;
        int n2 = n = this.mAdapter.getCount();
        if (!QMUIViewPager.access$000((QMUIViewPager)this.this$0)) return n2;
        n2 = n;
        if (n < 3) return n2;
        n2 = n * QMUIViewPager.access$100((QMUIViewPager)this.this$0);
        return n2;
    }

    public int getItemPosition(Object object) {
        return this.mAdapter.getItemPosition(object);
    }

    public CharSequence getPageTitle(int n) {
        int n2 = this.mAdapter.getCount();
        return this.mAdapter.getPageTitle(n % n2);
    }

    public float getPageWidth(int n) {
        return this.mAdapter.getPageWidth(n);
    }

    public Object instantiateItem(ViewGroup viewGroup, int n) {
        int n2 = n;
        if (!QMUIViewPager.access$000((QMUIViewPager)this.this$0)) return this.mAdapter.instantiateItem(viewGroup, n2);
        n2 = n;
        if (this.mAdapter.getCount() == 0) return this.mAdapter.instantiateItem(viewGroup, n2);
        n2 = n % this.mAdapter.getCount();
        return this.mAdapter.instantiateItem(viewGroup, n2);
    }

    public boolean isViewFromObject(View view, Object object) {
        return this.mAdapter.isViewFromObject(view, object);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mAdapter.registerDataSetObserver(dataSetObserver);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.mAdapter.restoreState(parcelable, classLoader);
    }

    public Parcelable saveState() {
        return this.mAdapter.saveState();
    }

    public void setPrimaryItem(ViewGroup viewGroup, int n, Object object) {
        this.mAdapter.setPrimaryItem(viewGroup, n, object);
    }

    public void startUpdate(ViewGroup viewGroup) {
        this.mAdapter.startUpdate(viewGroup);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mAdapter.unregisterDataSetObserver(dataSetObserver);
    }
}
