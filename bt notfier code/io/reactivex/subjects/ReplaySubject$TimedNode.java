/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicReference;

static final class ReplaySubject.TimedNode<T>
extends AtomicReference<ReplaySubject.TimedNode<T>> {
    private static final long serialVersionUID = 6404226426336033100L;
    final long time;
    final T value;

    ReplaySubject.TimedNode(T t, long l) {
        this.value = t;
        this.time = l;
    }
}
