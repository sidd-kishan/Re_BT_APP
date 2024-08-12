/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleSource
 */
package io.reactivex;

import io.reactivex.Single;
import io.reactivex.SingleSource;

public interface SingleTransformer<Upstream, Downstream> {
    public SingleSource<Downstream> apply(Single<Upstream> var1);
}
