/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutSupport
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;

static interface ObservableTimeout.TimeoutSelectorSupport
extends ObservableTimeoutTimed.TimeoutSupport {
    public void onTimeoutError(long var1, Throwable var3);
}
