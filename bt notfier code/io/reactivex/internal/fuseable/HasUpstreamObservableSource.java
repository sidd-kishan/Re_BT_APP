/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 */
package io.reactivex.internal.fuseable;

import io.reactivex.ObservableSource;

public interface HasUpstreamObservableSource<T> {
    public ObservableSource<T> source();
}
