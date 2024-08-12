/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public static class ActionBarOverlayLayout.LayoutParams
extends ViewGroup.MarginLayoutParams {
    public ActionBarOverlayLayout.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public ActionBarOverlayLayout.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ActionBarOverlayLayout.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ActionBarOverlayLayout.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}
