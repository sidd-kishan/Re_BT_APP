/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeEmitter
 */
package io.reactivex;

import io.reactivex.MaybeEmitter;

public interface MaybeOnSubscribe<T> {
    public void subscribe(MaybeEmitter<T> var1) throws Exception;
}
