/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableEmitter
 */
package io.reactivex;

import io.reactivex.FlowableEmitter;

public interface FlowableOnSubscribe<T> {
    public void subscribe(FlowableEmitter<T> var1) throws Exception;
}
