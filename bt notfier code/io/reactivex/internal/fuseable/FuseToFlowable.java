/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 */
package io.reactivex.internal.fuseable;

import io.reactivex.Flowable;

public interface FuseToFlowable<T> {
    public Flowable<T> fuseToFlowable();
}
