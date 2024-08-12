/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.operators.flowable;

static interface FlowableConcatMap.ConcatMapSupport<T> {
    public void innerComplete();

    public void innerError(Throwable var1);

    public void innerNext(T var1);
}
