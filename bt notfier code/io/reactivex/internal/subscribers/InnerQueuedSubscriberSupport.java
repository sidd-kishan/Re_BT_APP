/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscribers.InnerQueuedSubscriber
 */
package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscribers.InnerQueuedSubscriber;

public interface InnerQueuedSubscriberSupport<T> {
    public void drain();

    public void innerComplete(InnerQueuedSubscriber<T> var1);

    public void innerError(InnerQueuedSubscriber<T> var1, Throwable var2);

    public void innerNext(InnerQueuedSubscriber<T> var1, T var2);
}
