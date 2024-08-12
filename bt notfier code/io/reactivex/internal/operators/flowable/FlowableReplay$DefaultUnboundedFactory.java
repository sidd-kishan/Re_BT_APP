/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableReplay$UnboundedReplayBuffer
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableReplay;
import java.util.concurrent.Callable;

static final class FlowableReplay.DefaultUnboundedFactory
implements Callable<Object> {
    FlowableReplay.DefaultUnboundedFactory() {
    }

    @Override
    public Object call() {
        return new FlowableReplay.UnboundedReplayBuffer(16);
    }
}
