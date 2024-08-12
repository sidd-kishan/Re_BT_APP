/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableBufferTimed$BufferSkipBoundedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;

/*
 * Exception performing whole class analysis ignored.
 */
final class ObservableBufferTimed.BufferSkipBoundedObserver.RemoveFromBuffer
implements Runnable {
    private final U b;
    final ObservableBufferTimed.BufferSkipBoundedObserver this$0;

    ObservableBufferTimed.BufferSkipBoundedObserver.RemoveFromBuffer(U u) {
        this.this$0 = var1_1;
        this.b = u;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        ObservableBufferTimed.BufferSkipBoundedObserver bufferSkipBoundedObserver = this.this$0;
        synchronized (bufferSkipBoundedObserver) {
            this.this$0.buffers.remove(this.b);
        }
        bufferSkipBoundedObserver = this.this$0;
        ObservableBufferTimed.BufferSkipBoundedObserver.access$000((ObservableBufferTimed.BufferSkipBoundedObserver)bufferSkipBoundedObserver, this.b, (boolean)false, (Disposable)bufferSkipBoundedObserver.w);
    }
}
