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

public final class SpscArrayQueue<E>
extends AtomicReferenceArray<E>
implements SimplePlainQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask = this.length() - 1;
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    public SpscArrayQueue(int n) {
        super(Pow2.roundToPowerOfTwo((int)n));
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(n / 4, MAX_LOOK_AHEAD_STEP);
    }

    int calcElementOffset(long l) {
        int n = (int)l;
        return this.mask & n;
    }

    int calcElementOffset(long l, int n) {
        return (int)l & n;
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
        boolean bl = this.producerIndex.get() == this.consumerIndex.get();
        return bl;
    }

    E lvElement(int n) {
        return this.get(n);
    }

    public boolean offer(E e) {
        if (e == null) throw new NullPointerException("Null is not a valid element");
        int n = this.mask;
        long l = this.producerIndex.get();
        int n2 = this.calcElementOffset(l, n);
        if (l >= this.producerLookAhead) {
            long l2 = (long)this.lookAheadStep + l;
            if (this.lvElement(this.calcElementOffset(l2, n)) == null) {
                this.producerLookAhead = l2;
            } else if (this.lvElement(n2) != null) {
                return false;
            }
        }
        this.soElement(n2, e);
        this.soProducerIndex(l + 1L);
        return true;
    }

    public boolean offer(E e, E e2) {
        boolean bl = this.offer(e) && this.offer(e2);
        return bl;
    }

    public E poll() {
        long l = this.consumerIndex.get();
        int n = this.calcElementOffset(l);
        E e = this.lvElement(n);
        if (e == null) {
            return null;
        }
        this.soConsumerIndex(l + 1L);
        this.soElement(n, null);
        return e;
    }

    void soConsumerIndex(long l) {
        this.consumerIndex.lazySet(l);
    }

    void soElement(int n, E e) {
        this.lazySet(n, e);
    }

    void soProducerIndex(long l) {
        this.producerIndex.lazySet(l);
    }
}
