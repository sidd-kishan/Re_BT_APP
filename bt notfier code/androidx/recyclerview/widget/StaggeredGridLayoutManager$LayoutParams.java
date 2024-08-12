/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$Span
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public static class StaggeredGridLayoutManager.LayoutParams
extends RecyclerView.LayoutParams {
    public static final int INVALID_SPAN_ID = -1;
    boolean mFullSpan;
    StaggeredGridLayoutManager.Span mSpan;

    public StaggeredGridLayoutManager.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public StaggeredGridLayoutManager.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public StaggeredGridLayoutManager.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public StaggeredGridLayoutManager.LayoutParams(RecyclerView.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public final int getSpanIndex() {
        StaggeredGridLayoutManager.Span span = this.mSpan;
        if (span != null) return span.mIndex;
        return -1;
    }

    public boolean isFullSpan() {
        return this.mFullSpan;
    }

    public void setFullSpan(boolean bl) {
        this.mFullSpan = bl;
    }
}
