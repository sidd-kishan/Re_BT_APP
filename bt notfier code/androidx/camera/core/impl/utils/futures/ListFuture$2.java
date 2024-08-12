/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.ListFuture
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ListFuture;

class ListFuture.2
implements Runnable {
    final ListFuture this$0;

    ListFuture.2(ListFuture listFuture) {
        this.this$0 = listFuture;
    }

    @Override
    public void run() {
        this.this$0.mValues = null;
        this.this$0.mFutures = null;
    }
}
