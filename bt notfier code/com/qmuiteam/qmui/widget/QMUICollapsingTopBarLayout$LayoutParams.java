/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  com.qmuiteam.qmui.R$styleable
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qmuiteam.qmui.R;

public static class QMUICollapsingTopBarLayout.LayoutParams
extends FrameLayout.LayoutParams {
    public static final int COLLAPSE_MODE_OFF = 0;
    public static final int COLLAPSE_MODE_PARALLAX = 2;
    public static final int COLLAPSE_MODE_PIN = 1;
    private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
    int mCollapseMode = 0;
    float mParallaxMult = 0.5f;

    public QMUICollapsingTopBarLayout.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public QMUICollapsingTopBarLayout.LayoutParams(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public QMUICollapsingTopBarLayout.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.QMUICollapsingTopBarLayout_Layout);
        this.mCollapseMode = context.getInt(R.styleable.QMUICollapsingTopBarLayout_Layout_qmui_layout_collapseMode, 0);
        this.setParallaxMultiplier(context.getFloat(R.styleable.QMUICollapsingTopBarLayout_Layout_qmui_layout_collapseParallaxMultiplier, 0.5f));
        context.recycle();
    }

    public QMUICollapsingTopBarLayout.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public QMUICollapsingTopBarLayout.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public QMUICollapsingTopBarLayout.LayoutParams(FrameLayout.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public int getCollapseMode() {
        return this.mCollapseMode;
    }

    public float getParallaxMultiplier() {
        return this.mParallaxMult;
    }

    public void setCollapseMode(int n) {
        this.mCollapseMode = n;
    }

    public void setParallaxMultiplier(float f) {
        this.mParallaxMult = f;
    }
}
