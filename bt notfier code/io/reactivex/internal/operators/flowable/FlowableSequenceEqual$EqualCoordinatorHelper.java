/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.operators.flowable;

static interface FlowableSequenceEqual.EqualCoordinatorHelper {
    public void drain();

    public void innerError(Throwable var1);
}
