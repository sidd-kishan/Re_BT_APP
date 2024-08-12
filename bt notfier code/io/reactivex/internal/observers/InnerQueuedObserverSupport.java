/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.observers.InnerQueuedObserver
 */
package io.reactivex.internal.observers;

import io.reactivex.internal.observers.InnerQueuedObserver;

public interface InnerQueuedObserverSupport<T> {
    public void drain();

    public void innerComplete(InnerQueuedObserver<T> var1);

    public void innerError(InnerQueuedObserver<T> var1, Throwable var2);

    public void innerNext(InnerQueuedObserver<T> var1, T var2);
}
