/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractIterator
 *  kotlin.collections.RingBuffer
 */
package kotlin.collections;

import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.collections.RingBuffer;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", "count", "", "index", "computeNext", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class RingBuffer.iterator.1
extends AbstractIterator<T> {
    private int count;
    private int index;
    final RingBuffer this$0;

    RingBuffer.iterator.1(RingBuffer ringBuffer) {
        this.this$0 = ringBuffer;
        this.count = ringBuffer.size();
        this.index = RingBuffer.access$getStartIndex$p((RingBuffer)ringBuffer);
    }

    protected void computeNext() {
        if (this.count == 0) {
            this.done();
        } else {
            this.setNext(RingBuffer.access$getBuffer$p((RingBuffer)this.this$0)[this.index]);
            RingBuffer ringBuffer = this.this$0;
            this.index = (this.index + 1) % RingBuffer.access$getCapacity$p((RingBuffer)ringBuffer);
            --this.count;
        }
    }
}
