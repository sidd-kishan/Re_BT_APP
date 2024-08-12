/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public static final class Snackbar.SnackbarLayout
extends BaseTransientBottomBar.SnackbarBaseLayout {
    public Snackbar.SnackbarLayout(Context context) {
        super(context);
    }

    public Snackbar.SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        n2 = this.getChildCount();
        int n3 = this.getMeasuredWidth();
        int n4 = this.getPaddingLeft();
        int n5 = this.getPaddingRight();
        n = 0;
        while (n < n2) {
            View view = this.getChildAt(n);
            if (view.getLayoutParams().width == -1) {
                view.measure(View.MeasureSpec.makeMeasureSpec((int)(n3 - n4 - n5), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)view.getMeasuredHeight(), (int)0x40000000));
            }
            ++n;
        }
    }
}
