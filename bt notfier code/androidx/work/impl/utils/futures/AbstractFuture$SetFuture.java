/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.futures.AbstractFuture
 */
package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class AbstractFuture.SetFuture<V>
implements Runnable {
    final ListenableFuture<? extends V> future;
    final AbstractFuture<V> owner;

    AbstractFuture.SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
        this.owner = abstractFuture;
        this.future = listenableFuture;
    }

    @Override
    public void run() {
        if (this.owner.value != this) {
            return;
        }
        Object object = AbstractFuture.getFutureValue(this.future);
        if (!AbstractFuture.ATOMIC_HELPER.casValue(this.owner, (Object)this, object)) return;
        AbstractFuture.complete(this.owner);
    }
}
