/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AdapterHelper$Callback
 *  androidx.recyclerview.widget.AdapterHelper$UpdateOp
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerView.6
implements AdapterHelper.Callback {
    final RecyclerView this$0;

    RecyclerView.6(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
        int n = updateOp.cmd;
        if (n != 1) {
            if (n != 2) {
                if (n != 4) {
                    if (n != 8) return;
                    this.this$0.mLayout.onItemsMoved(this.this$0, updateOp.positionStart, updateOp.itemCount, 1);
                } else {
                    this.this$0.mLayout.onItemsUpdated(this.this$0, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                }
            } else {
                this.this$0.mLayout.onItemsRemoved(this.this$0, updateOp.positionStart, updateOp.itemCount);
            }
        } else {
            this.this$0.mLayout.onItemsAdded(this.this$0, updateOp.positionStart, updateOp.itemCount);
        }
    }

    public RecyclerView.ViewHolder findViewHolder(int n) {
        RecyclerView.ViewHolder viewHolder = this.this$0.findViewHolderForPosition(n, true);
        if (viewHolder == null) {
            return null;
        }
        if (!this.this$0.mChildHelper.isHidden(viewHolder.itemView)) return viewHolder;
        return null;
    }

    public void markViewHoldersUpdated(int n, int n2, Object object) {
        this.this$0.viewRangeUpdate(n, n2, object);
        this.this$0.mItemsChanged = true;
    }

    public void offsetPositionsForAdd(int n, int n2) {
        this.this$0.offsetPositionRecordsForInsert(n, n2);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    public void offsetPositionsForMove(int n, int n2) {
        this.this$0.offsetPositionRecordsForMove(n, n2);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    public void offsetPositionsForRemovingInvisible(int n, int n2) {
        this.this$0.offsetPositionRecordsForRemove(n, n2, true);
        this.this$0.mItemsAddedOrRemoved = true;
        RecyclerView.State state = this.this$0.mState;
        state.mDeletedInvisibleItemCountSincePreviousLayout += n2;
    }

    public void offsetPositionsForRemovingLaidOutOrNewView(int n, int n2) {
        this.this$0.offsetPositionRecordsForRemove(n, n2, false);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
        this.dispatchUpdate(updateOp);
    }

    public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
        this.dispatchUpdate(updateOp);
    }
}
