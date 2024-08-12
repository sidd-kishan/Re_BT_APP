/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.operators.observable;

static final class ObservableCache.Node<T> {
    volatile ObservableCache.Node<T> next;
    final T[] values;

    ObservableCache.Node(int n) {
        this.values = new Object[n];
    }
}
