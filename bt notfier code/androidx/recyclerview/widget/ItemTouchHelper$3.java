/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  androidx.recyclerview.widget.ItemTouchHelper
 *  androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

class ItemTouchHelper.3
extends ItemTouchHelper.RecoverAnimation {
    final ItemTouchHelper this$0;
    final RecyclerView.ViewHolder val$prevSelected;
    final int val$swipeDir;

    ItemTouchHelper.3(ItemTouchHelper itemTouchHelper, RecyclerView.ViewHolder viewHolder, int n, int n2, float f, float f2, float f3, float f4, int n3, RecyclerView.ViewHolder viewHolder2) {
        this.this$0 = itemTouchHelper;
        this.val$swipeDir = n3;
        this.val$prevSelected = viewHolder2;
        super(viewHolder, n, n2, f, f2, f3, f4);
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (this.mOverridden) {
            return;
        }
        if (this.val$swipeDir <= 0) {
            this.this$0.mCallback.clearView(this.this$0.mRecyclerView, this.val$prevSelected);
        } else {
            this.this$0.mPendingCleanup.add(this.val$prevSelected.itemView);
            this.mIsPendingCleanup = true;
            int n = this.val$swipeDir;
            if (n > 0) {
                this.this$0.postDispatchSwipe((ItemTouchHelper.RecoverAnimation)this, n);
            }
        }
        if (this.this$0.mOverdrawChild != this.val$prevSelected.itemView) return;
        this.this$0.removeChildDrawingOrderCallbackIfNecessary(this.val$prevSelected.itemView);
    }
}
