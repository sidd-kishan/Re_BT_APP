/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 */
package io.reactivex;

import io.reactivex.MaybeObserver;

public interface MaybeSource<T> {
    public void subscribe(MaybeObserver<? super T> var1);
}
