/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.QueueDisposable
 */
package io.reactivex.internal.observers;

import io.reactivex.internal.fuseable.QueueDisposable;

public abstract class BasicQueueDisposable<T>
implements QueueDisposable<T> {
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
