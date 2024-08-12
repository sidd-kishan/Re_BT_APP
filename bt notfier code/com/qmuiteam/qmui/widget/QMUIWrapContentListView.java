/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View$MeasureSpec
 *  android.widget.ListView
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class QMUIWrapContentListView
extends ListView {
    private int mMaxHeight = 0x1FFFFFFF;

    public QMUIWrapContentListView(Context context) {
        super(context);
    }

    public QMUIWrapContentListView(Context context, int n) {
        super(context);
        this.mMaxHeight = n;
    }

    public QMUIWrapContentListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIWrapContentListView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, View.MeasureSpec.makeMeasureSpec((int)this.mMaxHeight, (int)Integer.MIN_VALUE));
    }

    public void setMaxHeight(int n) {
        if (this.mMaxHeight == n) return;
        this.mMaxHeight = n;
        this.requestLayout();
    }
}
