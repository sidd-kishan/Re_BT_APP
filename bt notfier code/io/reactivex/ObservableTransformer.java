/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 */
package io.reactivex;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

public interface ObservableTransformer<Upstream, Downstream> {
    public ObservableSource<Downstream> apply(Observable<Upstream> var1);
}
