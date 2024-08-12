/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 */
package io.reactivex.internal.fuseable;

import io.reactivex.Observable;

public interface FuseToObservable<T> {
    public Observable<T> fuseToObservable();
}
