/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 */
package io.reactivex.internal.fuseable;

import io.reactivex.Maybe;

public interface FuseToMaybe<T> {
    public Maybe<T> fuseToMaybe();
}
