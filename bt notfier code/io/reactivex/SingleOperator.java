/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 */
package io.reactivex;

import io.reactivex.SingleObserver;

public interface SingleOperator<Downstream, Upstream> {
    public SingleObserver<? super Upstream> apply(SingleObserver<? super Downstream> var1) throws Exception;
}
