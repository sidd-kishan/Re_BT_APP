/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

private static final class AbstractFuture.Listener {
    static final AbstractFuture.Listener TOMBSTONE = new AbstractFuture.Listener(null, null);
    final Executor executor;
    AbstractFuture.Listener next;
    final Runnable task;

    AbstractFuture.Listener(Runnable runnable, Executor executor) {
        this.task = runnable;
        this.executor = executor;
    }
}
