/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

static final class Functions.JustValue<T, U>
implements Callable<U>,
Function<T, U> {
    final U value;

    Functions.JustValue(U u) {
        this.value = u;
    }

    public U apply(T t) throws Exception {
        return this.value;
    }

    @Override
    public U call() throws Exception {
        return this.value;
    }
}
