/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.LinearLayout$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public static class LinearLayoutCompat.LayoutParams
extends LinearLayout.LayoutParams {
    public LinearLayoutCompat.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public LinearLayoutCompat.LayoutParams(int n, int n2, float f) {
        super(n, n2, f);
    }

    public LinearLayoutCompat.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public LinearLayoutCompat.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}
