/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.widget.ItemTouchHelper
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;

class ItemTouchHelper.1
implements Runnable {
    final ItemTouchHelper this$0;

    ItemTouchHelper.1(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    @Override
    public void run() {
        if (this.this$0.mSelected == null) return;
        if (!this.this$0.scrollIfNecessary()) return;
        if (this.this$0.mSelected != null) {
            ItemTouchHelper itemTouchHelper = this.this$0;
            itemTouchHelper.moveIfNecessary(itemTouchHelper.mSelected);
        }
        this.this$0.mRecyclerView.removeCallbacks(this.this$0.mScrollRunnable);
        ViewCompat.postOnAnimation((View)this.this$0.mRecyclerView, (Runnable)this);
    }
}
