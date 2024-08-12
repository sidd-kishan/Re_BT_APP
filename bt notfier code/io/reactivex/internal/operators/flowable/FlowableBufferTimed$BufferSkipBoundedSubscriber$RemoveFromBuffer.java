/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.flowable.FlowableBufferTimed$BufferSkipBoundedSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableBufferTimed;

/*
 * Exception performing whole class analysis ignored.
 */
final class FlowableBufferTimed.BufferSkipBoundedSubscriber.RemoveFromBuffer
implements Runnable {
    private final U buffer;
    final FlowableBufferTimed.BufferSkipBoundedSubscriber this$0;

    FlowableBufferTimed.BufferSkipBoundedSubscriber.RemoveFromBuffer(U u) {
        this.this$0 = var1_1;
        this.buffer = u;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        FlowableBufferTimed.BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = this.this$0;
        synchronized (bufferSkipBoundedSubscriber) {
            this.this$0.buffers.remove(this.buffer);
        }
        bufferSkipBoundedSubscriber = this.this$0;
        FlowableBufferTimed.BufferSkipBoundedSubscriber.access$000((FlowableBufferTimed.BufferSkipBoundedSubscriber)bufferSkipBoundedSubscriber, this.buffer, (boolean)false, (Disposable)bufferSkipBoundedSubscriber.w);
    }
}
