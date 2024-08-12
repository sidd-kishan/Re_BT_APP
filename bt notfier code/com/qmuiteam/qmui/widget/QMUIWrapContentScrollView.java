/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  com.qmuiteam.qmui.widget.QMUIObservableScrollView
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qmuiteam.qmui.widget.QMUIObservableScrollView;

public class QMUIWrapContentScrollView
extends QMUIObservableScrollView {
    private int mMaxHeight = 0x1FFFFFFF;

    public QMUIWrapContentScrollView(Context context) {
        super(context);
    }

    public QMUIWrapContentScrollView(Context context, int n) {
        super(context);
        this.mMaxHeight = n;
    }

    public QMUIWrapContentScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIWrapContentScrollView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    protected void onMeasure(int n, int n2) {
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        n2 = layoutParams.height > 0 && layoutParams.height <= this.mMaxHeight ? View.MeasureSpec.makeMeasureSpec((int)layoutParams.height, (int)0x40000000) : View.MeasureSpec.makeMeasureSpec((int)this.mMaxHeight, (int)Integer.MIN_VALUE);
        super.onMeasure(n, n2);
    }

    public void setMaxHeight(int n) {
        if (this.mMaxHeight == n) return;
        this.mMaxHeight = n;
        this.requestLayout();
    }
}
