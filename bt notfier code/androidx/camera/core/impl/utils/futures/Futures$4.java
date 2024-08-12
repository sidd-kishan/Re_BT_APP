/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

class Futures.4
implements Runnable {
    final ListenableFuture val$input;

    Futures.4(ListenableFuture listenableFuture) {
        this.val$input = listenableFuture;
    }

    @Override
    public void run() {
        this.val$input.cancel(true);
    }
}
