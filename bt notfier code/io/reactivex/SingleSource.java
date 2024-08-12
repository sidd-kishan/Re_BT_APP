/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 */
package io.reactivex;

import io.reactivex.SingleObserver;

public interface SingleSource<T> {
    public void subscribe(SingleObserver<? super T> var1);
}
