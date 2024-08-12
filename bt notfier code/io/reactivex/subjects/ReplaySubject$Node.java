/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicReference;

static final class ReplaySubject.Node<T>
extends AtomicReference<ReplaySubject.Node<T>> {
    private static final long serialVersionUID = 6404226426336033100L;
    final T value;

    ReplaySubject.Node(T t) {
        this.value = t;
    }
}
