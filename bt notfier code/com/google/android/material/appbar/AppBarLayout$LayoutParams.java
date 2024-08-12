/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 *  android.widget.LinearLayout$LayoutParams
 *  com.google.android.material.R$styleable
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.google.android.material.R;

public static class AppBarLayout.LayoutParams
extends LinearLayout.LayoutParams {
    static final int COLLAPSIBLE_FLAGS = 10;
    static final int FLAG_QUICK_RETURN = 5;
    static final int FLAG_SNAP = 17;
    public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
    public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
    public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
    public static final int SCROLL_FLAG_SCROLL = 1;
    public static final int SCROLL_FLAG_SNAP = 16;
    public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
    int scrollFlags = 1;
    Interpolator scrollInterpolator;

    public AppBarLayout.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public AppBarLayout.LayoutParams(int n, int n2, float f) {
        super(n, n2, f);
    }

    public AppBarLayout.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
        this.scrollFlags = attributeSet.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
        if (attributeSet.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
            this.scrollInterpolator = AnimationUtils.loadInterpolator((Context)context, (int)attributeSet.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
        }
        attributeSet.recycle();
    }

    public AppBarLayout.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public AppBarLayout.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public AppBarLayout.LayoutParams(LinearLayout.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public AppBarLayout.LayoutParams(AppBarLayout.LayoutParams layoutParams) {
        super((LinearLayout.LayoutParams)layoutParams);
        this.scrollFlags = layoutParams.scrollFlags;
        this.scrollInterpolator = layoutParams.scrollInterpolator;
    }

    public int getScrollFlags() {
        return this.scrollFlags;
    }

    public Interpolator getScrollInterpolator() {
        return this.scrollInterpolator;
    }

    boolean isCollapsible() {
        int n = this.scrollFlags;
        boolean bl = true;
        if ((n & 1) == 1 && (n & 0xA) != 0) return bl;
        bl = false;
        return bl;
    }

    public void setScrollFlags(int n) {
        this.scrollFlags = n;
    }

    public void setScrollInterpolator(Interpolator interpolator) {
        this.scrollInterpolator = interpolator;
    }
}
