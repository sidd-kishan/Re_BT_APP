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
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;

public class QMUIContinuousNestedBottomRecyclerView
extends RecyclerView
implements IQMUIContinuousNestedBottomView {
    public static final String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_bottom_rv_offset";
    public static final String KEY_SCROLL_INFO_POSITION = "@qmui_scroll_info_bottom_rv_pos";
    private IQMUIContinuousNestedScrollCommon.OnScrollNotifier mOnScrollNotifier;
    private final int[] mScrollConsumed = new int[2];

    public QMUIContinuousNestedBottomRecyclerView(Context context) {
        super(context);
        this.init();
    }

    public QMUIContinuousNestedBottomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    public QMUIContinuousNestedBottomRecyclerView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    static /* synthetic */ IQMUIContinuousNestedScrollCommon.OnScrollNotifier access$000(QMUIContinuousNestedBottomRecyclerView qMUIContinuousNestedBottomRecyclerView) {
        return qMUIContinuousNestedBottomRecyclerView.mOnScrollNotifier;
    }

    private void init() {
        this.setVerticalScrollBarEnabled(false);
        this.addOnScrollListener((RecyclerView.OnScrollListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void consumeScroll(int n) {
        if (n == Integer.MIN_VALUE) {
            this.scrollToPosition(0);
        } else {
            boolean bl = true;
            if (n == Integer.MAX_VALUE) {
                RecyclerView.Adapter adapter = this.getAdapter();
                if (adapter == null) return;
                this.scrollToPosition(adapter.getItemCount() - 1);
            } else {
                if (!this.hasNestedScrollingParent(0)) {
                    this.startNestedScroll(2, 0);
                    int[] nArray = this.mScrollConsumed;
                    nArray[0] = 0;
                    nArray[1] = 0;
                    this.dispatchNestedPreScroll(0, n, nArray, null, 0);
                    n -= this.mScrollConsumed[1];
                } else {
                    bl = false;
                }
                this.scrollBy(0, n);
                if (!bl) return;
                this.stopNestedScroll(0);
            }
        }
    }

    public int getContentHeight() {
        int n;
        if (this.getAdapter() == null) {
            return 0;
        }
        if (this.getLayoutManager() == null) {
            return 0;
        }
        int n2 = n = this.computeVerticalScrollRange();
        if (n <= this.getHeight()) return n2;
        n2 = -1;
        return n2;
    }

    public int getCurrentScroll() {
        return this.computeVerticalScrollOffset();
    }

    public int getScrollOffsetRange() {
        return Math.max(0, this.computeVerticalScrollRange() - this.getHeight());
    }

    public void injectScrollNotifier(IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mOnScrollNotifier = onScrollNotifier;
    }

    public void restoreScrollInfo(Bundle bundle) {
        RecyclerView.LayoutManager layoutManager = this.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) return;
        int n = bundle.getInt(KEY_SCROLL_INFO_POSITION, 0);
        int n2 = bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0);
        ((LinearLayoutManager)layoutManager).scrollToPositionWithOffset(n, n2);
        bundle = this.mOnScrollNotifier;
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

    public void smoothScrollYBy(int n, int n2) {
        this.startNestedScroll(2, 1);
        this.smoothScrollBy(0, n, null);
    }
}
