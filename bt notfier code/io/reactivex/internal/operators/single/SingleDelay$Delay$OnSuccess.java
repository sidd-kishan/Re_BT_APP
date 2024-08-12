/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.single.SingleDelay$Delay
 */
package io.reactivex.internal.operators.single;

import io.reactivex.internal.operators.single.SingleDelay;

final class SingleDelay.Delay.OnSuccess
implements Runnable {
    final SingleDelay.Delay this$1;
    private final T value;

    SingleDelay.Delay.OnSuccess(SingleDelay.Delay delay, T t) {
        this.this$1 = delay;
        this.value = t;
    }

    @Override
    public void run() {
        this.this$1.downstream.onSuccess(this.value);
    }
}
