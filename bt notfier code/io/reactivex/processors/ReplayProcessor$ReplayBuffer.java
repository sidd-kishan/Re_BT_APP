/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.processors.ReplayProcessor$ReplaySubscription
 */
package io.reactivex.processors;

import io.reactivex.processors.ReplayProcessor;

static interface ReplayProcessor.ReplayBuffer<T> {
    public void complete();

    public void error(Throwable var1);

    public Throwable getError();

    public T getValue();

    public T[] getValues(T[] var1);

    public boolean isDone();

    public void next(T var1);

    public void replay(ReplayProcessor.ReplaySubscription<T> var1);

    public int size();

    public void trimHead();
}
