/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.processors;

import java.util.concurrent.atomic.AtomicReference;

static final class ReplayProcessor.TimedNode<T>
extends AtomicReference<ReplayProcessor.TimedNode<T>> {
    private static final long serialVersionUID = 6404226426336033100L;
    final long time;
    final T value;

    ReplayProcessor.TimedNode(T t, long l) {
        this.value = t;
        this.time = l;
    }
}
