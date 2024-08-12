/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package com.google.android.material.chip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public static class ChipGroup.LayoutParams
extends ViewGroup.MarginLayoutParams {
    public ChipGroup.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public ChipGroup.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChipGroup.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ChipGroup.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}
