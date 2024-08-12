/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.AbstractResolvableFuture
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class AbstractResolvableFuture.SetFuture<V>
implements Runnable {
    final ListenableFuture<? extends V> future;
    final AbstractResolvableFuture<V> owner;

    AbstractResolvableFuture.SetFuture(AbstractResolvableFuture<V> abstractResolvableFuture, ListenableFuture<? extends V> listenableFuture) {
        this.owner = abstractResolvableFuture;
        this.future = listenableFuture;
    }

    @Override
    public void run() {
        if (this.owner.value != this) {
            return;
        }
        Object object = AbstractResolvableFuture.getFutureValue(this.future);
        if (!AbstractResolvableFuture.ATOMIC_HELPER.casValue(this.owner, (Object)this, object)) return;
        AbstractResolvableFuture.complete(this.owner);
    }
}
