/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.ItemTouchHelper
 *  androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

class ItemTouchHelper.4
implements Runnable {
    final ItemTouchHelper this$0;
    final ItemTouchHelper.RecoverAnimation val$anim;
    final int val$swipeDir;

    ItemTouchHelper.4(ItemTouchHelper itemTouchHelper, ItemTouchHelper.RecoverAnimation recoverAnimation, int n) {
        this.this$0 = itemTouchHelper;
        this.val$anim = recoverAnimation;
        this.val$swipeDir = n;
    }

    @Override
    public void run() {
        if (this.this$0.mRecyclerView == null) return;
        if (!this.this$0.mRecyclerView.isAttachedToWindow()) return;
        if (this.val$anim.mOverridden) return;
        if (this.val$anim.mViewHolder.getAbsoluteAdapterPosition() == -1) return;
        RecyclerView.ItemAnimator itemAnimator = this.this$0.mRecyclerView.getItemAnimator();
        if (!(itemAnimator != null && itemAnimator.isRunning(null) || this.this$0.hasRunningRecoverAnim())) {
            this.this$0.mCallback.onSwiped(this.val$anim.mViewHolder, this.val$swipeDir);
        } else {
            this.this$0.mRecyclerView.post((Runnable)this);
        }
    }
}
