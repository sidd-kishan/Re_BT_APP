/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.SimpleQueue
 */
package io.reactivex.internal.fuseable;

import io.reactivex.internal.fuseable.SimpleQueue;

public interface SimplePlainQueue<T>
extends SimpleQueue<T> {
    public T poll();
}
