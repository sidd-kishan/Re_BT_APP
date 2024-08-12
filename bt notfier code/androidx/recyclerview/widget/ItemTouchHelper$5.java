/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.ItemTouchHelper
 *  androidx.recyclerview.widget.RecyclerView$ChildDrawingOrderCallback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

class ItemTouchHelper.5
implements RecyclerView.ChildDrawingOrderCallback {
    final ItemTouchHelper this$0;

    ItemTouchHelper.5(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    public int onGetChildDrawingOrder(int n, int n2) {
        int n3;
        if (this.this$0.mOverdrawChild == null) {
            return n2;
        }
        int n4 = n3 = this.this$0.mOverdrawChildPosition;
        if (n3 == -1) {
            this.this$0.mOverdrawChildPosition = n4 = this.this$0.mRecyclerView.indexOfChild(this.this$0.mOverdrawChild);
        }
        if (n2 == n - 1) {
            return n4;
        }
        if (n2 < n4) return n2;
        ++n2;
        return n2;
    }
}
