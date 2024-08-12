/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 */
package io.reactivex;

import io.reactivex.MaybeObserver;

public interface MaybeOperator<Downstream, Upstream> {
    public MaybeObserver<? super Upstream> apply(MaybeObserver<? super Downstream> var1) throws Exception;
}
