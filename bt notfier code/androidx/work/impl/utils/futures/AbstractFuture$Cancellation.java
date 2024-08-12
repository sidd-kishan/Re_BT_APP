/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.futures.AbstractFuture
 */
package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture;

private static final class AbstractFuture.Cancellation {
    static final AbstractFuture.Cancellation CAUSELESS_CANCELLED;
    static final AbstractFuture.Cancellation CAUSELESS_INTERRUPTED;
    final Throwable cause;
    final boolean wasInterrupted;

    static {
        if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
        } else {
            CAUSELESS_CANCELLED = new AbstractFuture.Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new AbstractFuture.Cancellation(true, null);
        }
    }

    AbstractFuture.Cancellation(boolean bl, Throwable throwable) {
        this.wasInterrupted = bl;
        this.cause = throwable;
    }
}
