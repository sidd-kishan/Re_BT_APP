/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.AbstractResolvableFuture
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;

private static final class AbstractResolvableFuture.Cancellation {
    static final AbstractResolvableFuture.Cancellation CAUSELESS_CANCELLED;
    static final AbstractResolvableFuture.Cancellation CAUSELESS_INTERRUPTED;
    final Throwable cause;
    final boolean wasInterrupted;

    static {
        if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
        } else {
            CAUSELESS_CANCELLED = new AbstractResolvableFuture.Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new AbstractResolvableFuture.Cancellation(true, null);
        }
    }

    AbstractResolvableFuture.Cancellation(boolean bl, Throwable throwable) {
        this.wasInterrupted = bl;
        this.cause = throwable;
    }
}
