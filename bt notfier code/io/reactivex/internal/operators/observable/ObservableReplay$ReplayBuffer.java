/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableReplay;

static interface ObservableReplay.ReplayBuffer<T> {
    public void complete();

    public void error(Throwable var1);

    public void next(T var1);

    public void replay(ObservableReplay.InnerDisposable<T> var1);
}
