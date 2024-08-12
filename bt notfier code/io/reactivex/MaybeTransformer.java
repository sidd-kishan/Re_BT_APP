/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeSource
 */
package io.reactivex;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;

public interface MaybeTransformer<Upstream, Downstream> {
    public MaybeSource<Downstream> apply(Maybe<Upstream> var1);
}
