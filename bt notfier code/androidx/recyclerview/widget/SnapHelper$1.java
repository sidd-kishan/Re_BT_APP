/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  androidx.recyclerview.widget.SnapHelper
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

class SnapHelper.1
extends RecyclerView.OnScrollListener {
    boolean mScrolled;
    final SnapHelper this$0;

    SnapHelper.1(SnapHelper snapHelper) {
        this.this$0 = snapHelper;
        this.mScrolled = false;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int n) {
        super.onScrollStateChanged(recyclerView, n);
        if (n != 0) return;
        if (!this.mScrolled) return;
        this.mScrolled = false;
        this.this$0.snapToTargetExistingView();
    }

    public void onScrolled(RecyclerView recyclerView, int n, int n2) {
        if (n == 0) {
            if (n2 == 0) return;
        }
        this.mScrolled = true;
    }
}
