/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.ListFuture
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ListFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;

class ListFuture.3
implements Runnable {
    final ListFuture this$0;
    final int val$index;
    final ListenableFuture val$listenable;

    ListFuture.3(ListFuture listFuture, int n, ListenableFuture listenableFuture) {
        this.this$0 = listFuture;
        this.val$index = n;
        this.val$listenable = listenableFuture;
    }

    @Override
    public void run() {
        this.this$0.setOneValue(this.val$index, (Future)this.val$listenable);
    }
}
