/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 */
package io.reactivex.observables;

import io.reactivex.Observable;

public abstract class GroupedObservable<K, T>
extends Observable<T> {
    final K key;

    protected GroupedObservable(K k) {
        this.key = k;
    }

    public K getKey() {
        return this.key;
    }
}
