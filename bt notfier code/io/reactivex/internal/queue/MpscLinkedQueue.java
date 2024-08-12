/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.queue.MpscLinkedQueue$LinkedQueueNode
 */
package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T>
implements SimplePlainQueue<T> {
    private final AtomicReference<LinkedQueueNode<T>> consumerNode;
    private final AtomicReference<LinkedQueueNode<T>> producerNode = new AtomicReference();

    public MpscLinkedQueue() {
        this.consumerNode = new AtomicReference();
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        this.spConsumerNode(linkedQueueNode);
        this.xchgProducerNode(linkedQueueNode);
    }

    public void clear() {
        while (this.poll() != null) {
            if (this.isEmpty()) return;
        }
    }

    public boolean isEmpty() {
        boolean bl = this.lvConsumerNode() == this.lvProducerNode();
        return bl;
    }

    LinkedQueueNode<T> lpConsumerNode() {
        return this.consumerNode.get();
    }

    LinkedQueueNode<T> lvConsumerNode() {
        return this.consumerNode.get();
    }

    LinkedQueueNode<T> lvProducerNode() {
        return this.producerNode.get();
    }

    public boolean offer(T object) {
        if (object == null) throw new NullPointerException("Null is not a valid element");
        object = new LinkedQueueNode(object);
        this.xchgProducerNode((LinkedQueueNode<T>)object).soNext(object);
        return true;
    }

    public boolean offer(T t, T t2) {
        this.offer(t);
        this.offer(t2);
        return true;
    }

    public T poll() {
        Object object = this.lpConsumerNode();
        LinkedQueueNode linkedQueueNode = object.lvNext();
        if (linkedQueueNode != null) {
            object = linkedQueueNode.getAndNullValue();
            this.spConsumerNode(linkedQueueNode);
            return (T)object;
        }
        if (object == this.lvProducerNode()) return null;
        while ((linkedQueueNode = object.lvNext()) == null) {
        }
        object = linkedQueueNode.getAndNullValue();
        this.spConsumerNode(linkedQueueNode);
        return (T)object;
    }

    void spConsumerNode(LinkedQueueNode<T> linkedQueueNode) {
        this.consumerNode.lazySet(linkedQueueNode);
    }

    LinkedQueueNode<T> xchgProducerNode(LinkedQueueNode<T> linkedQueueNode) {
        return this.producerNode.getAndSet(linkedQueueNode);
    }
}
