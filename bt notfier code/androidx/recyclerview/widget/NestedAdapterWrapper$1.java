/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Preconditions
 *  androidx.recyclerview.widget.NestedAdapterWrapper
 *  androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 */
package androidx.recyclerview.widget;

import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.RecyclerView;

class NestedAdapterWrapper.1
extends RecyclerView.AdapterDataObserver {
    final NestedAdapterWrapper this$0;

    NestedAdapterWrapper.1(NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = nestedAdapterWrapper;
    }

    public void onChanged() {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCachedItemCount = nestedAdapterWrapper.adapter.getItemCount();
        this.this$0.mCallback.onChanged(this.this$0);
    }

    public void onItemRangeChanged(int n, int n2) {
        this.this$0.mCallback.onItemRangeChanged(this.this$0, n, n2, null);
    }

    public void onItemRangeChanged(int n, int n2, Object object) {
        this.this$0.mCallback.onItemRangeChanged(this.this$0, n, n2, object);
    }

    public void onItemRangeInserted(int n, int n2) {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCachedItemCount += n2;
        this.this$0.mCallback.onItemRangeInserted(this.this$0, n, n2);
        if (this.this$0.mCachedItemCount <= 0) return;
        if (this.this$0.adapter.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) return;
        this.this$0.mCallback.onStateRestorationPolicyChanged(this.this$0);
    }

    public void onItemRangeMoved(int n, int n2, int n3) {
        boolean bl = true;
        if (n3 != 1) {
            bl = false;
        }
        Preconditions.checkArgument((boolean)bl, (Object)"moving more than 1 item is not supported in RecyclerView");
        this.this$0.mCallback.onItemRangeMoved(this.this$0, n, n2);
    }

    public void onItemRangeRemoved(int n, int n2) {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCachedItemCount -= n2;
        this.this$0.mCallback.onItemRangeRemoved(this.this$0, n, n2);
        if (this.this$0.mCachedItemCount >= 1) return;
        if (this.this$0.adapter.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) return;
        this.this$0.mCallback.onStateRestorationPolicyChanged(this.this$0);
    }

    public void onStateRestorationPolicyChanged() {
        this.this$0.mCallback.onStateRestorationPolicyChanged(this.this$0);
    }
}
