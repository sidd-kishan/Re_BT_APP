/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

class RecyclerView.2
implements Runnable {
    final RecyclerView this$0;

    RecyclerView.2(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    @Override
    public void run() {
        if (this.this$0.mItemAnimator != null) {
            this.this$0.mItemAnimator.runPendingAnimations();
        }
        this.this$0.mPostedAnimatorRunner = false;
    }
}
