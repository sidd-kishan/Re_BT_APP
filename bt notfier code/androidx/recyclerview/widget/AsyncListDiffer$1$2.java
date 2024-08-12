/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AsyncListDiffer$1
 *  androidx.recyclerview.widget.DiffUtil$DiffResult
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;

class AsyncListDiffer.2
implements Runnable {
    final AsyncListDiffer.1 this$1;
    final DiffUtil.DiffResult val$result;

    AsyncListDiffer.2(AsyncListDiffer.1 var1_1, DiffUtil.DiffResult diffResult) {
        this.this$1 = var1_1;
        this.val$result = diffResult;
    }

    @Override
    public void run() {
        if (this.this$1.this$0.mMaxScheduledGeneration != this.this$1.val$runGeneration) return;
        this.this$1.this$0.latchList(this.this$1.val$newList, this.val$result, this.this$1.val$commitCallback);
    }
}
