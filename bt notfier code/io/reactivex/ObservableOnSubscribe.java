/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableEmitter
 */
package io.reactivex;

import io.reactivex.ObservableEmitter;

public interface ObservableOnSubscribe<T> {
    public void subscribe(ObservableEmitter<T> var1) throws Exception;
}
