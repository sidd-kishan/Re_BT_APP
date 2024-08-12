/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

class RecyclerView.1
implements Runnable {
    final RecyclerView this$0;

    RecyclerView.1(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    @Override
    public void run() {
        if (!this.this$0.mFirstLayoutComplete) return;
        if (this.this$0.isLayoutRequested()) return;
        if (!this.this$0.mIsAttached) {
            this.this$0.requestLayout();
            return;
        }
        if (this.this$0.mLayoutSuppressed) {
            this.this$0.mLayoutWasDefered = true;
            return;
        }
        this.this$0.consumePendingUpdateOperations();
    }
}
