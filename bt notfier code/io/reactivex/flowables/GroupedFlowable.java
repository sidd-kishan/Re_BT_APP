/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 */
package io.reactivex.flowables;

import io.reactivex.Flowable;

public abstract class GroupedFlowable<K, T>
extends Flowable<T> {
    final K key;

    protected GroupedFlowable(K k) {
        this.key = k;
    }

    public K getKey() {
        return this.key;
    }
}
