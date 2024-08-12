/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

private class RecyclerView.RecyclerViewDataObserver
extends RecyclerView.AdapterDataObserver {
    final RecyclerView this$0;

    RecyclerView.RecyclerViewDataObserver(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void onChanged() {
        this.this$0.assertNotInLayoutOrScroll(null);
        this.this$0.mState.mStructureChanged = true;
        this.this$0.processDataSetCompletelyChanged(true);
        if (this.this$0.mAdapterHelper.hasPendingUpdates()) return;
        this.this$0.requestLayout();
    }

    public void onItemRangeChanged(int n, int n2, Object object) {
        this.this$0.assertNotInLayoutOrScroll(null);
        if (!this.this$0.mAdapterHelper.onItemRangeChanged(n, n2, object)) return;
        this.triggerUpdateProcessor();
    }

    public void onItemRangeInserted(int n, int n2) {
        this.this$0.assertNotInLayoutOrScroll(null);
        if (!this.this$0.mAdapterHelper.onItemRangeInserted(n, n2)) return;
        this.triggerUpdateProcessor();
    }

    public void onItemRangeMoved(int n, int n2, int n3) {
        this.this$0.assertNotInLayoutOrScroll(null);
        if (!this.this$0.mAdapterHelper.onItemRangeMoved(n, n2, n3)) return;
        this.triggerUpdateProcessor();
    }

    public void onItemRangeRemoved(int n, int n2) {
        this.this$0.assertNotInLayoutOrScroll(null);
        if (!this.this$0.mAdapterHelper.onItemRangeRemoved(n, n2)) return;
        this.triggerUpdateProcessor();
    }

    public void onStateRestorationPolicyChanged() {
        if (this.this$0.mPendingSavedState == null) {
            return;
        }
        RecyclerView.Adapter adapter = this.this$0.mAdapter;
        if (adapter == null) return;
        if (!adapter.canRestoreState()) return;
        this.this$0.requestLayout();
    }

    void triggerUpdateProcessor() {
        if (RecyclerView.POST_UPDATES_ON_ANIMATION && this.this$0.mHasFixedSize && this.this$0.mIsAttached) {
            RecyclerView recyclerView = this.this$0;
            ViewCompat.postOnAnimation((View)recyclerView, (Runnable)recyclerView.mUpdateChildViewsRunnable);
        } else {
            this.this$0.mAdapterUpdateDuringMeasure = true;
            this.this$0.requestLayout();
        }
    }
}
