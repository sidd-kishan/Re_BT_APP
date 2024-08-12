/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.functions;

import java.util.concurrent.Callable;

static final class Functions.NullCallable
implements Callable<Object> {
    Functions.NullCallable() {
    }

    @Override
    public Object call() {
        return null;
    }
}
