/*
 * Decompiled with CFR 0.152.
 */
package androidx.concurrent.futures;

import java.util.concurrent.Executor;

private static final class AbstractResolvableFuture.Listener {
    static final AbstractResolvableFuture.Listener TOMBSTONE = new AbstractResolvableFuture.Listener(null, null);
    final Executor executor;
    AbstractResolvableFuture.Listener next;
    final Runnable task;

    AbstractResolvableFuture.Listener(Runnable runnable, Executor executor) {
        this.task = runnable;
        this.executor = executor;
    }
}
