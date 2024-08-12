/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AsyncListDiffer$1
 *  androidx.recyclerview.widget.DiffUtil$Callback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;

class AsyncListDiffer.1
extends DiffUtil.Callback {
    final AsyncListDiffer.1 this$1;

    AsyncListDiffer.1(AsyncListDiffer.1 var1_1) {
        this.this$1 = var1_1;
    }

    public boolean areContentsTheSame(int n, int n2) {
        Object e = this.this$1.val$oldList.get(n);
        Object e2 = this.this$1.val$newList.get(n2);
        if (e != null && e2 != null) {
            return this.this$1.this$0.mConfig.getDiffCallback().areContentsTheSame(e, e2);
        }
        if (e != null) throw new AssertionError();
        if (e2 != null) throw new AssertionError();
        return true;
    }

    public boolean areItemsTheSame(int n, int n2) {
        Object e = this.this$1.val$oldList.get(n);
        Object e2 = this.this$1.val$newList.get(n2);
        if (e != null && e2 != null) {
            return this.this$1.this$0.mConfig.getDiffCallback().areItemsTheSame(e, e2);
        }
        boolean bl = e == null && e2 == null;
        return bl;
    }

    public Object getChangePayload(int n, int n2) {
        Object e = this.this$1.val$oldList.get(n);
        Object e2 = this.this$1.val$newList.get(n2);
        if (e == null) throw new AssertionError();
        if (e2 == null) throw new AssertionError();
        return this.this$1.this$0.mConfig.getDiffCallback().getChangePayload(e, e2);
    }

    public int getNewListSize() {
        return this.this$1.val$newList.size();
    }

    public int getOldListSize() {
        return this.this$1.val$oldList.size();
    }
}
