/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.drawerlayout.widget.DrawerLayout
 */
package androidx.drawerlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.drawerlayout.widget.DrawerLayout;

public static class DrawerLayout.LayoutParams
extends ViewGroup.MarginLayoutParams {
    private static final int FLAG_IS_CLOSING = 4;
    private static final int FLAG_IS_OPENED = 1;
    private static final int FLAG_IS_OPENING = 2;
    public int gravity = 0;
    boolean isPeeking;
    float onScreen;
    int openState;

    public DrawerLayout.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public DrawerLayout.LayoutParams(int n, int n2, int n3) {
        this(n, n2);
        this.gravity = n3;
    }

    public DrawerLayout.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
        this.gravity = context.getInt(0, 0);
        context.recycle();
    }

    public DrawerLayout.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public DrawerLayout.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public DrawerLayout.LayoutParams(DrawerLayout.LayoutParams layoutParams) {
        super((ViewGroup.MarginLayoutParams)layoutParams);
        this.gravity = layoutParams.gravity;
    }
}
