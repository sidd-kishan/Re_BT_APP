/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Paint
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;

public static class SlidingPaneLayout.LayoutParams
extends ViewGroup.MarginLayoutParams {
    private static final int[] ATTRS = new int[]{0x1010181};
    Paint dimPaint;
    boolean dimWhenOffset;
    boolean slideable;
    public float weight = 0.0f;

    public SlidingPaneLayout.LayoutParams() {
        super(-1, -1);
    }

    public SlidingPaneLayout.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public SlidingPaneLayout.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.weight = context.getFloat(0, 0.0f);
        context.recycle();
    }

    public SlidingPaneLayout.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public SlidingPaneLayout.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public SlidingPaneLayout.LayoutParams(SlidingPaneLayout.LayoutParams layoutParams) {
        super((ViewGroup.MarginLayoutParams)layoutParams);
        this.weight = layoutParams.weight;
    }
}
