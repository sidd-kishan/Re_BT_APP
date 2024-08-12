/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AsyncListDiffer
 *  androidx.recyclerview.widget.DiffUtil
 *  androidx.recyclerview.widget.DiffUtil$Callback
 *  androidx.recyclerview.widget.DiffUtil$DiffResult
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

class AsyncListDiffer.1
implements Runnable {
    final AsyncListDiffer this$0;
    final Runnable val$commitCallback;
    final List val$newList;
    final List val$oldList;
    final int val$runGeneration;

    AsyncListDiffer.1(AsyncListDiffer asyncListDiffer, List list, List list2, int n, Runnable runnable) {
        this.this$0 = asyncListDiffer;
        this.val$oldList = list;
        this.val$newList = list2;
        this.val$runGeneration = n;
        this.val$commitCallback = runnable;
    }

    @Override
    public void run() {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff((DiffUtil.Callback)new /* Unavailable Anonymous Inner Class!! */);
        this.this$0.mMainThreadExecutor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
