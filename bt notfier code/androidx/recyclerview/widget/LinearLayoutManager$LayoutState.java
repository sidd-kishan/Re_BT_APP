/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$Recycler
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

static class LinearLayoutManager.LayoutState {
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
    static final String TAG = "LLM#LayoutState";
    int mAvailable;
    int mCurrentPosition;
    int mExtraFillSpace = 0;
    boolean mInfinite;
    boolean mIsPreLayout = false;
    int mItemDirection;
    int mLastScrollDelta;
    int mLayoutDirection;
    int mNoRecycleSpace = 0;
    int mOffset;
    boolean mRecycle = true;
    List<RecyclerView.ViewHolder> mScrapList = null;
    int mScrollingOffset;

    LinearLayoutManager.LayoutState() {
    }

    private View nextViewFromScrapList() {
        int n = this.mScrapList.size();
        int n2 = 0;
        while (n2 < n) {
            View view = this.mScrapList.get((int)n2).itemView;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
            if (!layoutParams.isItemRemoved() && this.mCurrentPosition == layoutParams.getViewLayoutPosition()) {
                this.assignPositionFromScrapList(view);
                return view;
            }
            ++n2;
        }
        return null;
    }

    public void assignPositionFromScrapList() {
        this.assignPositionFromScrapList(null);
    }

    public void assignPositionFromScrapList(View view) {
        this.mCurrentPosition = (view = this.nextViewInLimitedList(view)) == null ? -1 : ((RecyclerView.LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
    }

    boolean hasMore(RecyclerView.State state) {
        int n = this.mCurrentPosition;
        boolean bl = n >= 0 && n < state.getItemCount();
        return bl;
    }

    void log() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("avail:");
        stringBuilder.append(this.mAvailable);
        stringBuilder.append(", ind:");
        stringBuilder.append(this.mCurrentPosition);
        stringBuilder.append(", dir:");
        stringBuilder.append(this.mItemDirection);
        stringBuilder.append(", offset:");
        stringBuilder.append(this.mOffset);
        stringBuilder.append(", layoutDir:");
        stringBuilder.append(this.mLayoutDirection);
        Log.d((String)TAG, (String)stringBuilder.toString());
    }

    View next(RecyclerView.Recycler recycler) {
        if (this.mScrapList != null) {
            return this.nextViewFromScrapList();
        }
        recycler = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return recycler;
    }

    public View nextViewInLimitedList(View view) {
        int n = this.mScrapList.size();
        View view2 = null;
        int n2 = Integer.MAX_VALUE;
        int n3 = 0;
        while (true) {
            View view3 = view2;
            if (n3 >= n) return view3;
            View view4 = this.mScrapList.get((int)n3).itemView;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view4.getLayoutParams();
            view3 = view2;
            int n4 = n2;
            if (view4 != view) {
                if (layoutParams.isItemRemoved()) {
                    view3 = view2;
                    n4 = n2;
                } else {
                    int n5 = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
                    if (n5 < 0) {
                        view3 = view2;
                        n4 = n2;
                    } else {
                        view3 = view2;
                        n4 = n2;
                        if (n5 < n2) {
                            view2 = view4;
                            if (n5 == 0) {
                                view3 = view2;
                                return view3;
                            }
                            n4 = n5;
                            view3 = view2;
                        }
                    }
                }
            }
            ++n3;
            view2 = view3;
            n2 = n4;
        }
    }
}
