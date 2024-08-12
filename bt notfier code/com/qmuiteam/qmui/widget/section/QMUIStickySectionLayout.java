/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.qmuiteam.qmui.layout.QMUIFrameLayout
 *  com.qmuiteam.qmui.widget.section.QMUISection$Model
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewCallback
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration$Callback
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout$2
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout$StickySectionWrapViewConfig
 */
package com.qmuiteam.qmui.widget.section;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout;

public class QMUIStickySectionLayout
extends QMUIFrameLayout
implements QMUIStickySectionAdapter.ViewCallback {
    private Runnable mPendingScrollAction = null;
    private RecyclerView mRecyclerView;
    private QMUIStickySectionItemDecoration mStickySectionItemDecoration;
    private int mStickySectionViewHeight = -1;
    private QMUIFrameLayout mStickySectionWrapView;

    public QMUIStickySectionLayout(Context context) {
        this(context, null);
    }

    public QMUIStickySectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIStickySectionLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mStickySectionWrapView = new QMUIFrameLayout(context);
        context = new RecyclerView(context);
        this.mRecyclerView = context;
        this.addView((View)context, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.addView((View)this.mStickySectionWrapView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
        this.mStickySectionWrapView.addOnLayoutChangeListener((View.OnLayoutChangeListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ int access$000(QMUIStickySectionLayout qMUIStickySectionLayout) {
        return qMUIStickySectionLayout.mStickySectionViewHeight;
    }

    static /* synthetic */ int access$002(QMUIStickySectionLayout qMUIStickySectionLayout, int n) {
        qMUIStickySectionLayout.mStickySectionViewHeight = n;
        return n;
    }

    static /* synthetic */ Runnable access$100(QMUIStickySectionLayout qMUIStickySectionLayout) {
        return qMUIStickySectionLayout.mPendingScrollAction;
    }

    static /* synthetic */ Runnable access$102(QMUIStickySectionLayout qMUIStickySectionLayout, Runnable runnable) {
        qMUIStickySectionLayout.mPendingScrollAction = runnable;
        return runnable;
    }

    public void configStickySectionWrapView(StickySectionWrapViewConfig stickySectionWrapViewConfig) {
        if (stickySectionWrapViewConfig == null) return;
        stickySectionWrapViewConfig.config(this.mStickySectionWrapView);
    }

    public RecyclerView.ViewHolder findViewHolderForAdapterPosition(int n) {
        return this.mRecyclerView.findViewHolderForAdapterPosition(n);
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public View getStickySectionView() {
        if (this.mStickySectionWrapView.getVisibility() != 0) return null;
        if (this.mStickySectionWrapView.getChildCount() != 0) return this.mStickySectionWrapView.getChildAt(0);
        return null;
    }

    public QMUIFrameLayout getStickySectionWrapView() {
        return this.mStickySectionWrapView;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (this.mStickySectionItemDecoration == null) return;
        QMUIFrameLayout qMUIFrameLayout = this.mStickySectionWrapView;
        qMUIFrameLayout.layout(qMUIFrameLayout.getLeft(), this.mStickySectionItemDecoration.getTargetTop(), this.mStickySectionWrapView.getRight(), this.mStickySectionItemDecoration.getTargetTop() + this.mStickySectionWrapView.getHeight());
    }

    public void requestChildFocus(View view) {
        this.mRecyclerView.requestChildFocus(view, null);
    }

    public void scrollToPosition(int n, boolean bl, boolean bl2) {
        this.mPendingScrollAction = null;
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        if (adapter == null) return;
        if (n < 0) return;
        if (n >= adapter.getItemCount()) return;
        adapter = this.mRecyclerView.getLayoutManager();
        if (adapter instanceof LinearLayoutManager) {
            adapter = (LinearLayoutManager)adapter;
            int n2 = adapter.findFirstCompletelyVisibleItemPosition();
            int n3 = adapter.findLastCompletelyVisibleItemPosition();
            int n4 = 0;
            if (!bl) {
                if (this.mStickySectionViewHeight <= 0) {
                    this.mPendingScrollAction = new /* Unavailable Anonymous Inner Class!! */;
                }
                n4 = this.mStickySectionWrapView.getHeight();
            }
            if (n >= n2 + 1 && n <= n3) {
                if (!bl2) return;
            }
            adapter.scrollToPositionWithOffset(n, n4);
        } else {
            this.mRecyclerView.scrollToPosition(n);
        }
    }

    public <H extends QMUISection.Model<H>, T extends QMUISection.Model<T>, VH extends QMUIStickySectionAdapter.ViewHolder> void setAdapter(QMUIStickySectionAdapter<H, T, VH> qMUIStickySectionAdapter) {
        this.setAdapter(qMUIStickySectionAdapter, true);
    }

    public <H extends QMUISection.Model<H>, T extends QMUISection.Model<T>, VH extends QMUIStickySectionAdapter.ViewHolder> void setAdapter(QMUIStickySectionAdapter<H, T, VH> qMUIStickySectionAdapter, boolean bl) {
        if (bl) {
            2 var3_3 = new /* Unavailable Anonymous Inner Class!! */;
            var3_3 = new QMUIStickySectionItemDecoration((ViewGroup)this.mStickySectionWrapView, (QMUIStickySectionItemDecoration.Callback)var3_3);
            this.mStickySectionItemDecoration = var3_3;
            this.mRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)var3_3);
        }
        qMUIStickySectionAdapter.setViewCallback((QMUIStickySectionAdapter.ViewCallback)this);
        this.mRecyclerView.setAdapter(qMUIStickySectionAdapter);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.mRecyclerView.setLayoutManager(layoutManager);
    }
}
