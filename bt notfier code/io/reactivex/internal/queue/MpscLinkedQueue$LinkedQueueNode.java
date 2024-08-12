/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;

static final class MpscLinkedQueue.LinkedQueueNode<E>
extends AtomicReference<MpscLinkedQueue.LinkedQueueNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    MpscLinkedQueue.LinkedQueueNode() {
    }

    MpscLinkedQueue.LinkedQueueNode(E e) {
        this.spValue(e);
    }

    public E getAndNullValue() {
        E e = this.lpValue();
        this.spValue(null);
        return e;
    }

    public E lpValue() {
        return this.value;
    }

    public MpscLinkedQueue.LinkedQueueNode<E> lvNext() {
        return (MpscLinkedQueue.LinkedQueueNode)this.get();
    }

    public void soNext(MpscLinkedQueue.LinkedQueueNode<E> linkedQueueNode) {
        this.lazySet(linkedQueueNode);
    }

    public void spValue(E e) {
        this.value = e;
    }
}
