/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.futures.AbstractFuture
 */
package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class AbstractFuture.Failure {
    static final AbstractFuture.Failure FALLBACK_INSTANCE = new AbstractFuture.Failure((Throwable)new /* Unavailable Anonymous Inner Class!! */);
    final Throwable exception;

    AbstractFuture.Failure(Throwable throwable) {
        this.exception = (Throwable)AbstractFuture.checkNotNull((Object)throwable);
    }
}
