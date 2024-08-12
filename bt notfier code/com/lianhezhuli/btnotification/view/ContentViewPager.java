/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  androidx.viewpager.widget.ViewPager
 */
package com.lianhezhuli.btnotification.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class ContentViewPager
extends ViewPager {
    public ContentViewPager(Context context) {
        super(context);
    }

    public ContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int n, int n2) {
        n2 = 0;
        int n3 = 0;
        while (true) {
            if (n2 >= this.getChildCount()) {
                super.onMeasure(n, View.MeasureSpec.makeMeasureSpec((int)n3, (int)0x40000000));
                return;
            }
            View view = this.getChildAt(n2);
            view.measure(n, View.MeasureSpec.makeMeasureSpec((int)0, (int)0));
            int n4 = view.getMeasuredHeight();
            int n5 = n3;
            if (n4 > n3) {
                n5 = n4;
            }
            ++n2;
            n3 = n5;
        }
    }
}
