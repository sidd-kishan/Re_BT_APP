/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 */
package io.reactivex;

import io.reactivex.Observer;

public interface ObservableSource<T> {
    public void subscribe(Observer<? super T> var1);
}
