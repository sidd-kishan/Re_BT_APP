/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.recyclerview.widget.ViewInfoStore$ProcessCallback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewInfoStore;

class RecyclerView.4
implements ViewInfoStore.ProcessCallback {
    final RecyclerView this$0;

    RecyclerView.4(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void processAppeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        this.this$0.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
    }

    public void processDisappeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        this.this$0.mRecycler.unscrapView(viewHolder);
        this.this$0.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
    }

    public void processPersistent(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.this$0.mDataSetHasChangedAfterLayout) {
            if (!this.this$0.mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) return;
            this.this$0.postAnimationRunner();
        } else {
            if (!this.this$0.mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) return;
            this.this$0.postAnimationRunner();
        }
    }

    public void unused(RecyclerView.ViewHolder viewHolder) {
        this.this$0.mLayout.removeAndRecycleView(viewHolder.itemView, this.this$0.mRecycler);
    }
}
