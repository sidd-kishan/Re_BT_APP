/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.single.SingleDelay$Delay
 */
package io.reactivex.internal.operators.single;

import io.reactivex.internal.operators.single.SingleDelay;

final class SingleDelay.Delay.OnError
implements Runnable {
    private final Throwable e;
    final SingleDelay.Delay this$1;

    SingleDelay.Delay.OnError(SingleDelay.Delay delay, Throwable throwable) {
        this.this$1 = delay;
        this.e = throwable;
    }

    @Override
    public void run() {
        this.this$1.downstream.onError(this.e);
    }
}
