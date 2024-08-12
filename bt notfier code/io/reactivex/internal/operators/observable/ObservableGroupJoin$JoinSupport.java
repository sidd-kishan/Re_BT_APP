/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightEndObserver
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableGroupJoin;

static interface ObservableGroupJoin.JoinSupport {
    public void innerClose(boolean var1, ObservableGroupJoin.LeftRightEndObserver var2);

    public void innerCloseError(Throwable var1);

    public void innerComplete(ObservableGroupJoin.LeftRightObserver var1);

    public void innerError(Throwable var1);

    public void innerValue(boolean var1, Object var2);
}
