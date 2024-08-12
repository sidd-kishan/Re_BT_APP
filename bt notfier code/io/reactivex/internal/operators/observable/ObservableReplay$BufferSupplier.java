/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableReplay;

static interface ObservableReplay.BufferSupplier<T> {
    public ObservableReplay.ReplayBuffer<T> call();
}
