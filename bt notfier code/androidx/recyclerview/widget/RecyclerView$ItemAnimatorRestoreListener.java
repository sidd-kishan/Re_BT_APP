/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemAnimatorListener
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

private class RecyclerView.ItemAnimatorRestoreListener
implements RecyclerView.ItemAnimator.ItemAnimatorListener {
    final RecyclerView this$0;

    RecyclerView.ItemAnimatorRestoreListener(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void onAnimationFinished(RecyclerView.ViewHolder viewHolder) {
        viewHolder.setIsRecyclable(true);
        if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
            viewHolder.mShadowedHolder = null;
        }
        viewHolder.mShadowingHolder = null;
        if (viewHolder.shouldBeKeptAsChild()) return;
        if (this.this$0.removeAnimatingView(viewHolder.itemView)) return;
        if (!viewHolder.isTmpDetached()) return;
        this.this$0.removeDetachedView(viewHolder.itemView, false);
    }
}
