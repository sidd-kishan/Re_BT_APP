/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.util.Pow2
 */
package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscLinkedArrayQueue<T>
implements SimplePlainQueue<T> {
    private static final Object HAS_NEXT;
    static final int MAX_LOOK_AHEAD_STEP;
    AtomicReferenceArray<Object> consumerBuffer;
    final AtomicLong consumerIndex;
    final int consumerMask;
    AtomicReferenceArray<Object> producerBuffer;
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;
    int producerLookAheadStep;
    final int producerMask;

    static {
        MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
        HAS_NEXT = new Object();
    }

    public SpscLinkedArrayQueue(int n) {
        this.consumerIndex = new AtomicLong();
        int n2 = Pow2.roundToPowerOfTwo((int)Math.max(8, n));
        n = n2 - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(n2 + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = n;
        this.adjustLookAheadStep(n2);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = n;
        this.producerLookAhead = n - 1;
        this.soProducerIndex(0L);
    }

    private void adjustLookAheadStep(int n) {
        this.producerLookAheadStep = Math.min(n / 4, MAX_LOOK_AHEAD_STEP);
    }

    private static int calcDirectOffset(int n) {
        return n;
    }

    private static int calcWrappedOffset(long l, int n) {
        return SpscLinkedArrayQueue.calcDirectOffset((int)l & n);
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int n) {
        return atomicReferenceArray.get(n);
    }

    private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> atomicReferenceArray, int n) {
        n = SpscLinkedArrayQueue.calcDirectOffset(n);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray)SpscLinkedArrayQueue.lvElement(atomicReferenceArray, n);
        SpscLinkedArrayQueue.soElement(atomicReferenceArray, n, null);
        return atomicReferenceArray2;
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long l, int n) {
        this.consumerBuffer = atomicReferenceArray;
        return (T)SpscLinkedArrayQueue.lvElement(atomicReferenceArray, SpscLinkedArrayQueue.calcWrappedOffset(l, n));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long l, int n) {
        this.consumerBuffer = atomicReferenceArray;
        Object object = SpscLinkedArrayQueue.lvElement(atomicReferenceArray, n = SpscLinkedArrayQueue.calcWrappedOffset(l, n));
        if (object == null) return (T)object;
        SpscLinkedArrayQueue.soElement(atomicReferenceArray, n, null);
        this.soConsumerIndex(l + 1L);
        return (T)object;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long l, int n, T t, long l2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<Object>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        this.producerLookAhead = l2 + l - 1L;
        SpscLinkedArrayQueue.soElement(atomicReferenceArray2, n, t);
        this.soNext(atomicReferenceArray, atomicReferenceArray2);
        SpscLinkedArrayQueue.soElement(atomicReferenceArray, n, HAS_NEXT);
        this.soProducerIndex(l + 1L);
    }

    private void soConsumerIndex(long l) {
        this.consumerIndex.lazySet(l);
    }

    private static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int n, Object object) {
        atomicReferenceArray.lazySet(n, object);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        SpscLinkedArrayQueue.soElement(atomicReferenceArray, SpscLinkedArrayQueue.calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void soProducerIndex(long l) {
        this.producerIndex.lazySet(l);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t, long l, int n) {
        SpscLinkedArrayQueue.soElement(atomicReferenceArray, n, t);
        this.soProducerIndex(l + 1L);
        return true;
    }

    public void clear() {
        while (true) {
            if (this.poll() != null) {
                continue;
            }
            if (this.isEmpty()) return;
        }
    }

    public boolean isEmpty() {
        boolean bl = this.lvProducerIndex() == this.lvConsumerIndex();
        return bl;
    }

    public boolean offer(T t) {
        if (t == null) throw new NullPointerException("Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long l = this.lpProducerIndex();
        int n = this.producerMask;
        int n2 = SpscLinkedArrayQueue.calcWrappedOffset(l, n);
        if (l < this.producerLookAhead) {
            return this.writeToQueue(atomicReferenceArray, t, l, n2);
        }
        long l2 = (long)this.producerLookAheadStep + l;
        if (SpscLinkedArrayQueue.lvElement(atomicReferenceArray, SpscLinkedArrayQueue.calcWrappedOffset(l2, n)) == null) {
            this.producerLookAhead = l2 - 1L;
            return this.writeToQueue(atomicReferenceArray, t, l, n2);
        }
        if (SpscLinkedArrayQueue.lvElement(atomicReferenceArray, SpscLinkedArrayQueue.calcWrappedOffset(1L + l, n)) == null) {
            return this.writeToQueue(atomicReferenceArray, t, l, n2);
        }
        this.resize(atomicReferenceArray, l, n2, t, n);
        return true;
    }

    public boolean offer(T t, T t2) {
        int n;
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long l = this.lvProducerIndex();
        long l2 = 2L + l;
        if (SpscLinkedArrayQueue.lvElement(atomicReferenceArray, SpscLinkedArrayQueue.calcWrappedOffset(l2, n = this.producerMask)) == null) {
            n = SpscLinkedArrayQueue.calcWrappedOffset(l, n);
            SpscLinkedArrayQueue.soElement(atomicReferenceArray, n + 1, t2);
            SpscLinkedArrayQueue.soElement(atomicReferenceArray, n, t);
            this.soProducerIndex(l2);
        } else {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<Object>(atomicReferenceArray.length());
            this.producerBuffer = atomicReferenceArray2;
            n = SpscLinkedArrayQueue.calcWrappedOffset(l, n);
            SpscLinkedArrayQueue.soElement(atomicReferenceArray2, n + 1, t2);
            SpscLinkedArrayQueue.soElement(atomicReferenceArray2, n, t);
            this.soNext(atomicReferenceArray, atomicReferenceArray2);
            SpscLinkedArrayQueue.soElement(atomicReferenceArray, n, HAS_NEXT);
            this.soProducerIndex(l2);
        }
        return true;
    }

    public T peek() {
        int n;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long l = this.lpConsumerIndex();
        Object object = SpscLinkedArrayQueue.lvElement(atomicReferenceArray, SpscLinkedArrayQueue.calcWrappedOffset(l, n = this.consumerMask));
        if (object != HAS_NEXT) return (T)object;
        return this.newBufferPeek(this.lvNextBufferAndUnlink(atomicReferenceArray, n + 1), l, n);
    }

    public T poll() {
        int n;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long l = this.lpConsumerIndex();
        int n2 = SpscLinkedArrayQueue.calcWrappedOffset(l, n = this.consumerMask);
        Object object = SpscLinkedArrayQueue.lvElement(atomicReferenceArray, n2);
        boolean bl = object == HAS_NEXT;
        if (object != null && !bl) {
            SpscLinkedArrayQueue.soElement(atomicReferenceArray, n2, null);
            this.soConsumerIndex(l + 1L);
            return (T)object;
        }
        if (!bl) return null;
        return this.newBufferPoll(this.lvNextBufferAndUnlink(atomicReferenceArray, n + 1), l, n);
    }

    public int size() {
        long l = this.lvConsumerIndex();
        while (true) {
            long l2 = this.lvProducerIndex();
            long l3 = this.lvConsumerIndex();
            if (l == l3) {
                return (int)(l2 - l3);
            }
            l = l3;
        }
    }
}
