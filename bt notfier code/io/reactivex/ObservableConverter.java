/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 */
package io.reactivex;

import io.reactivex.Observable;

public interface ObservableConverter<T, R> {
    public R apply(Observable<T> var1);
}
