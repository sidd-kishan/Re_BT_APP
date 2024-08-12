/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableSource
 */
package io.reactivex;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;

public interface CompletableTransformer {
    public CompletableSource apply(Completable var1);
}
