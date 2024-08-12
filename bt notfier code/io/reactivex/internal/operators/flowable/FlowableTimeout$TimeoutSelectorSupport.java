/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSupport
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;

static interface FlowableTimeout.TimeoutSelectorSupport
extends FlowableTimeoutTimed.TimeoutSupport {
    public void onTimeoutError(long var1, Throwable var3);
}
