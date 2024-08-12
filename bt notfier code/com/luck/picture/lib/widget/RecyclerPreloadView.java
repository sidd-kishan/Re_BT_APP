/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  com.luck.picture.lib.listener.OnRecyclerViewPreloadMoreListener
 */
package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.listener.OnRecyclerViewPreloadMoreListener;

public class RecyclerPreloadView
extends RecyclerView {
    private static final int BOTTOM_DEFAULT = 1;
    public static final int BOTTOM_PRELOAD = 2;
    private static final String TAG = RecyclerPreloadView.class.getSimpleName();
    public boolean isEnabledLoadMore = false;
    public boolean isInTheBottom = false;
    private int mFirstVisiblePosition;
    private int mLastVisiblePosition;
    private OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadListener;
    private int reachBottomRow = 1;

    public RecyclerPreloadView(Context context) {
        super(context);
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public int getFirstVisiblePosition() {
        return this.mFirstVisiblePosition;
    }

    public int getLastVisiblePosition() {
        return this.mLastVisiblePosition;
    }

    public boolean isEnabledLoadMore() {
        return this.isEnabledLoadMore;
    }

    public void onScrollStateChanged(int n) {
        RecyclerView.LayoutManager layoutManager;
        super.onScrollStateChanged(n);
        if (n != 0) {
            if (n != 1) return;
        }
        if (!((layoutManager = this.getLayoutManager()) instanceof GridLayoutManager)) return;
        layoutManager = (GridLayoutManager)layoutManager;
        this.mFirstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        this.mLastVisiblePosition = layoutManager.findLastVisibleItemPosition();
    }

    /*
     * Unable to fully structure code
     */
    public void onScrolled(int var1_1, int var2_2) {
        super.onScrolled(var1_1, var2_2);
        if (this.onRecyclerViewPreloadListener == null) return;
        if (this.isEnabledLoadMore == false) return;
        var4_3 = this.getLayoutManager();
        if (var4_3 == null) throw new RuntimeException("LayoutManager is null,Please check it!");
        var3_4 = this.getAdapter();
        if (var3_4 == null) throw new RuntimeException("Adapter is null,Please check it!");
        if (!(var4_3 instanceof GridLayoutManager)) ** GOTO lbl-1000
        var4_3 = (GridLayoutManager)var4_3;
        var1_1 = var3_4.getItemCount() / var4_3.getSpanCount();
        if (var4_3.findLastVisibleItemPosition() / var4_3.getSpanCount() >= var1_1 - this.reachBottomRow) {
            var1_1 = 1;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = 0;
        }
        if (var1_1 == 0) {
            this.isInTheBottom = false;
        } else if (!this.isInTheBottom) {
            this.onRecyclerViewPreloadListener.onRecyclerViewPreloadMore();
            if (var2_2 <= 0) return;
            this.isInTheBottom = true;
        } else {
            if (var2_2 != 0) return;
            this.isInTheBottom = false;
        }
    }

    public void setEnabledLoadMore(boolean bl) {
        this.isEnabledLoadMore = bl;
    }

    public void setOnRecyclerViewPreloadListener(OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadMoreListener) {
        this.onRecyclerViewPreloadListener = onRecyclerViewPreloadMoreListener;
    }

    public void setReachBottomRow(int n) {
        int n2 = n;
        if (n < 1) {
            n2 = 1;
        }
        this.reachBottomRow = n2;
    }
}
