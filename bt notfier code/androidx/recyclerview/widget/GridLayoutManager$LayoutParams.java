/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public static class GridLayoutManager.LayoutParams
extends RecyclerView.LayoutParams {
    public static final int INVALID_SPAN_ID = -1;
    int mSpanIndex = -1;
    int mSpanSize = 0;

    public GridLayoutManager.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public GridLayoutManager.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GridLayoutManager.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public GridLayoutManager.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public GridLayoutManager.LayoutParams(RecyclerView.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public int getSpanIndex() {
        return this.mSpanIndex;
    }

    public int getSpanSize() {
        return this.mSpanSize;
    }
}
