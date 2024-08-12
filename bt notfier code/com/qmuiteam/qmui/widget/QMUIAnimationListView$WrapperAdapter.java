/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  android.os.Looper
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ListAdapter
 *  com.qmuiteam.qmui.QMUILog
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView$WrapperAdapter$1
 */
package com.qmuiteam.qmui.widget;

import android.database.DataSetObserver;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;

private static class QMUIAnimationListView.WrapperAdapter
extends BaseAdapter {
    private ListAdapter mAdapter;
    private boolean mIsAnimationEnabled;
    private final DataSetObserver mObserver;
    private boolean mShouldNotifyChange = true;

    public QMUIAnimationListView.WrapperAdapter(ListAdapter listAdapter) {
        1 var2_2 = new /* Unavailable Anonymous Inner Class!! */;
        this.mObserver = var2_2;
        this.mIsAnimationEnabled = false;
        this.mAdapter = listAdapter;
        listAdapter.registerDataSetObserver((DataSetObserver)var2_2);
    }

    static /* synthetic */ boolean access$700(QMUIAnimationListView.WrapperAdapter wrapperAdapter) {
        return wrapperAdapter.mShouldNotifyChange;
    }

    public int getCount() {
        return this.mAdapter.getCount();
    }

    public Object getItem(int n) {
        return this.mAdapter.getItem(n);
    }

    public long getItemId(int n) {
        return this.mAdapter.getItemId(n);
    }

    public int getItemViewType(int n) {
        return this.mAdapter.getItemViewType(n);
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        return this.mAdapter.getView(n, view, viewGroup);
    }

    public int getViewTypeCount() {
        return this.mAdapter.getViewTypeCount();
    }

    public boolean hasStableIds() {
        boolean bl;
        this.mIsAnimationEnabled = bl = this.mAdapter.hasStableIds();
        return bl;
    }

    public boolean isAnimationEnabled() {
        return this.mIsAnimationEnabled;
    }

    public void notifyDataSetChanged() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            QMUILog.d((String)"QMUIAnimationListView", (String)"notifyDataSetChanged not in main Thread", (Object[])new Object[0]);
            return;
        }
        super.notifyDataSetChanged();
    }

    public void setShouldNotifyChange(boolean bl) {
        this.mShouldNotifyChange = bl;
    }
}
