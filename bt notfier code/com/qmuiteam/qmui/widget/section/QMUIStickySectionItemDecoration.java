/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$State
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration$Callback
 */
package com.qmuiteam.qmui.widget.section;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration;
import java.lang.ref.WeakReference;

public class QMUIStickySectionItemDecoration<VH extends QMUIStickySectionAdapter.ViewHolder>
extends RecyclerView.ItemDecoration {
    private Callback<VH> mCallback;
    private VH mStickyHeaderViewHolder;
    private int mStickyHeaderViewPosition = -1;
    private int mTargetTop = 0;
    private WeakReference<ViewGroup> mWeakSectionContainer;

    public QMUIStickySectionItemDecoration(ViewGroup viewGroup, Callback<VH> callback) {
        this.mCallback = callback;
        this.mWeakSectionContainer = new WeakReference<ViewGroup>(viewGroup);
        this.mCallback.registerAdapterDataObserver((RecyclerView.AdapterDataObserver)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ int access$000(QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration) {
        return qMUIStickySectionItemDecoration.mStickyHeaderViewPosition;
    }

    static /* synthetic */ int access$002(QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration, int n) {
        qMUIStickySectionItemDecoration.mStickyHeaderViewPosition = n;
        return n;
    }

    static /* synthetic */ QMUIStickySectionAdapter.ViewHolder access$100(QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration) {
        return qMUIStickySectionItemDecoration.mStickyHeaderViewHolder;
    }

    static /* synthetic */ WeakReference access$200(QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration) {
        return qMUIStickySectionItemDecoration.mWeakSectionContainer;
    }

    static /* synthetic */ void access$300(QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration, ViewGroup viewGroup, QMUIStickySectionAdapter.ViewHolder viewHolder, int n) {
        qMUIStickySectionItemDecoration.bindStickyViewHolder(viewGroup, viewHolder, n);
    }

    static /* synthetic */ void access$400(QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration, boolean bl) {
        qMUIStickySectionItemDecoration.setHeaderVisibility(bl);
    }

    private void bindStickyViewHolder(ViewGroup viewGroup, VH VH, int n) {
        this.mCallback.bindViewHolder(VH, n);
        viewGroup.removeAllViews();
        viewGroup.addView(((QMUIStickySectionAdapter.ViewHolder)VH).itemView);
    }

    private VH createStickyViewHolder(RecyclerView recyclerView, int n, int n2) {
        recyclerView = this.mCallback.createViewHolder((ViewGroup)recyclerView, n2);
        recyclerView.isForStickyHeader = true;
        return (VH)recyclerView;
    }

    private void setHeaderVisibility(boolean bl) {
        ViewGroup viewGroup = (ViewGroup)this.mWeakSectionContainer.get();
        if (viewGroup == null) {
            return;
        }
        int n = bl ? 0 : 8;
        viewGroup.setVisibility(n);
        this.mCallback.onHeaderVisibilityChanged(bl);
    }

    public int getTargetTop() {
        return this.mTargetTop;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State object) {
        canvas = (ViewGroup)this.mWeakSectionContainer.get();
        if (canvas == null) return;
        if (recyclerView.getChildCount() == 0) return;
        if (recyclerView.getAdapter() == null) {
            return;
        }
        object = recyclerView.getLayoutManager();
        if (!(object instanceof LinearLayoutManager)) {
            this.setHeaderVisibility(false);
            return;
        }
        int n = ((LinearLayoutManager)object).findFirstVisibleItemPosition();
        if (n == -1) {
            this.setHeaderVisibility(false);
            return;
        }
        int n2 = this.mCallback.getRelativeStickyItemPosition(n);
        if (n2 == -1) {
            this.setHeaderVisibility(false);
            return;
        }
        n = this.mCallback.getItemViewType(n2);
        if (n == -1) {
            this.setHeaderVisibility(false);
            return;
        }
        object = this.mStickyHeaderViewHolder;
        if (object == null || object.getItemViewType() != n) {
            this.mStickyHeaderViewHolder = this.createStickyViewHolder(recyclerView, n2, n);
        }
        if (this.mStickyHeaderViewPosition != n2) {
            this.mStickyHeaderViewPosition = n2;
            this.bindStickyViewHolder((ViewGroup)canvas, this.mStickyHeaderViewHolder, n2);
        }
        this.setHeaderVisibility(true);
        n = canvas.getHeight();
        object = recyclerView.findChildViewUnder((float)(recyclerView.getWidth() / 2), (float)(n - 1));
        if (object == null) {
            this.mTargetTop = n = recyclerView.getTop();
            ViewCompat.offsetTopAndBottom((View)canvas, (int)(n - canvas.getTop()));
            return;
        }
        if (this.mCallback.isHeaderItem(recyclerView.getChildAdapterPosition((View)object))) {
            this.mTargetTop = n = object.getTop() + recyclerView.getTop() - canvas.getHeight();
            ViewCompat.offsetTopAndBottom((View)canvas, (int)(n - canvas.getTop()));
            return;
        }
        this.mTargetTop = n = recyclerView.getTop();
        ViewCompat.offsetTopAndBottom((View)canvas, (int)(n - canvas.getTop()));
    }
}
