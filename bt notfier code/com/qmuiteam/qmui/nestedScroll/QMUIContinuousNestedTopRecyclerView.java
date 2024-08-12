/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView;

public class QMUIContinuousNestedTopRecyclerView
extends RecyclerView
implements IQMUIContinuousNestedTopView {
    public static final String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_top_rv_offset";
    public static final String KEY_SCROLL_INFO_POSITION = "@qmui_scroll_info_top_rv_pos";
    private final int[] mScrollConsumed = new int[2];
    private IQMUIContinuousNestedScrollCommon.OnScrollNotifier mScrollNotifier;

    public QMUIContinuousNestedTopRecyclerView(Context context) {
        this(context, null);
        this.init();
    }

    public QMUIContinuousNestedTopRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.init();
    }

    public QMUIContinuousNestedTopRecyclerView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    private void init() {
        this.setVerticalScrollBarEnabled(false);
    }

    public int consumeScroll(int n) {
        if (n == Integer.MIN_VALUE) {
            this.scrollToPosition(0);
            return Integer.MIN_VALUE;
        }
        int n2 = 1;
        if (n == Integer.MAX_VALUE) {
            RecyclerView.Adapter adapter = this.getAdapter();
            if (adapter == null) return Integer.MAX_VALUE;
            this.scrollToPosition(adapter.getItemCount() - 1);
            return Integer.MAX_VALUE;
        }
        if (!this.hasNestedScrollingParent(0)) {
            this.startNestedScroll(2, 0);
            int[] nArray = this.mScrollConsumed;
            nArray[0] = 0;
            nArray[1] = 0;
            this.dispatchNestedPreScroll(0, n, nArray, null, 0);
            int n3 = n - this.mScrollConsumed[1];
            n = n2;
            n2 = n3;
        } else {
            int n4 = 0;
            n2 = n;
            n = n4;
        }
        this.scrollBy(0, n2);
        if (n == 0) return 0;
        this.stopNestedScroll(0);
        return 0;
    }

    public int getCurrentScroll() {
        return this.computeVerticalScrollOffset();
    }

    public int getScrollOffsetRange() {
        return Math.max(0, this.computeVerticalScrollRange() - this.getHeight());
    }

    public void injectScrollNotifier(IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mScrollNotifier = onScrollNotifier;
    }

    public void onScrolled(int n, int n2) {
        super.onScrolled(n, n2);
        IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mScrollNotifier;
        if (onScrollNotifier == null) return;
        onScrollNotifier.notify(this.getCurrentScroll(), this.getScrollOffsetRange());
    }

    public void restoreScrollInfo(Bundle bundle) {
        RecyclerView.LayoutManager layoutManager = this.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) return;
        int n = bundle.getInt(KEY_SCROLL_INFO_POSITION, 0);
        int n2 = bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0);
        ((LinearLayoutManager)layoutManager).scrollToPositionWithOffset(n, n2);
        bundle = this.mScrollNotifier;
        if (bundle == null) return;
        bundle.notify(this.getCurrentScroll(), this.getScrollOffsetRange());
    }

    public void saveScrollInfo(Bundle bundle) {
        RecyclerView.LayoutManager layoutManager = this.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) return;
        layoutManager = (LinearLayoutManager)layoutManager;
        int n = layoutManager.findFirstVisibleItemPosition();
        int n2 = (layoutManager = layoutManager.findViewByPosition(n)) == null ? 0 : layoutManager.getTop();
        bundle.putInt(KEY_SCROLL_INFO_POSITION, n);
        bundle.putInt(KEY_SCROLL_INFO_OFFSET, n2);
    }
}
