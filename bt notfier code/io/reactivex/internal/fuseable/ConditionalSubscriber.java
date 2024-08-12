/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 */
package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

public interface ConditionalSubscriber<T>
extends FlowableSubscriber<T> {
    public boolean tryOnNext(T var1);
}
