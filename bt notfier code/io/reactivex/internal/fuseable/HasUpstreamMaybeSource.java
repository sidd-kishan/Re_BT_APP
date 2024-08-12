/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeSource
 */
package io.reactivex.internal.fuseable;

import io.reactivex.MaybeSource;

public interface HasUpstreamMaybeSource<T> {
    public MaybeSource<T> source();
}
