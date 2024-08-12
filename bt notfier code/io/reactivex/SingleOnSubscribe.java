/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleEmitter
 */
package io.reactivex;

import io.reactivex.SingleEmitter;

public interface SingleOnSubscribe<T> {
    public void subscribe(SingleEmitter<T> var1) throws Exception;
}
