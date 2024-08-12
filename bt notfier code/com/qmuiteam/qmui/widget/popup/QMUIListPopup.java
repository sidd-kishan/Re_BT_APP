/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.BaseAdapter
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ListAdapter
 *  com.qmuiteam.qmui.widget.QMUIWrapContentListView
 *  com.qmuiteam.qmui.widget.popup.QMUIPopup
 */
package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.qmuiteam.qmui.widget.QMUIWrapContentListView;
import com.qmuiteam.qmui.widget.popup.QMUIPopup;

public class QMUIListPopup
extends QMUIPopup {
    private BaseAdapter mAdapter;

    public QMUIListPopup(Context context, int n, BaseAdapter baseAdapter) {
        super(context, n);
        this.mAdapter = baseAdapter;
    }

    public void create(int n, int n2, AdapterView.OnItemClickListener onItemClickListener) {
        QMUIWrapContentListView qMUIWrapContentListView = new QMUIWrapContentListView(this.mContext, n2);
        qMUIWrapContentListView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(n, n2));
        qMUIWrapContentListView.setAdapter((ListAdapter)this.mAdapter);
        qMUIWrapContentListView.setVerticalScrollBarEnabled(false);
        qMUIWrapContentListView.setOnItemClickListener(onItemClickListener);
        qMUIWrapContentListView.setDivider(null);
        this.setContentView((View)qMUIWrapContentListView);
    }
}
