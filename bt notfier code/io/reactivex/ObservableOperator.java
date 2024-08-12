/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 */
package io.reactivex;

import io.reactivex.Observer;

public interface ObservableOperator<Downstream, Upstream> {
    public Observer<? super Upstream> apply(Observer<? super Downstream> var1) throws Exception;
}
