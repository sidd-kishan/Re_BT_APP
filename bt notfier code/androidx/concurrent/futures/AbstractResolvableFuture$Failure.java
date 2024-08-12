/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.AbstractResolvableFuture
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class AbstractResolvableFuture.Failure {
    static final AbstractResolvableFuture.Failure FALLBACK_INSTANCE = new AbstractResolvableFuture.Failure((Throwable)new /* Unavailable Anonymous Inner Class!! */);
    final Throwable exception;

    AbstractResolvableFuture.Failure(Throwable throwable) {
        this.exception = (Throwable)AbstractResolvableFuture.checkNotNull((Object)throwable);
    }
}
