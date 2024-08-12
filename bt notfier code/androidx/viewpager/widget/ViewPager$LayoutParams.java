/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  androidx.viewpager.widget.ViewPager
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;

public static class ViewPager.LayoutParams
extends ViewGroup.LayoutParams {
    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor = 0.0f;

    public ViewPager.LayoutParams() {
        super(-1, -1);
    }

    public ViewPager.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
        this.gravity = context.getInteger(0, 48);
        context.recycle();
    }
}
