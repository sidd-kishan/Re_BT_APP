/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleSource
 */
package io.reactivex.internal.fuseable;

import io.reactivex.SingleSource;

public interface HasUpstreamSingleSource<T> {
    public SingleSource<T> source();
}
