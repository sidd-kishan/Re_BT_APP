/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.operators.flowable;

static final class FlowableCache.Node<T> {
    volatile FlowableCache.Node<T> next;
    final T[] values;

    FlowableCache.Node(int n) {
        this.values = new Object[n];
    }
}
