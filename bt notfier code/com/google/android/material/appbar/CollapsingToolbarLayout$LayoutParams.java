/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  com.google.android.material.R$styleable
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R;

public static class CollapsingToolbarLayout.LayoutParams
extends FrameLayout.LayoutParams {
    public static final int COLLAPSE_MODE_OFF = 0;
    public static final int COLLAPSE_MODE_PARALLAX = 2;
    public static final int COLLAPSE_MODE_PIN = 1;
    private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
    int collapseMode = 0;
    float parallaxMult = 0.5f;

    public CollapsingToolbarLayout.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public CollapsingToolbarLayout.LayoutParams(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public CollapsingToolbarLayout.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
        this.collapseMode = context.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
        this.setParallaxMultiplier(context.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
        context.recycle();
    }

    public CollapsingToolbarLayout.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public CollapsingToolbarLayout.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public CollapsingToolbarLayout.LayoutParams(FrameLayout.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public int getCollapseMode() {
        return this.collapseMode;
    }

    public float getParallaxMultiplier() {
        return this.parallaxMult;
    }

    public void setCollapseMode(int n) {
        this.collapseMode = n;
    }

    public void setParallaxMultiplier(float f) {
        this.parallaxMult = f;
    }
}
