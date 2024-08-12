/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.util.ExceptionHelper
 */
package io.reactivex.internal.util;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class AtomicThrowable
extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable throwable) {
        return ExceptionHelper.addThrowable((AtomicReference)this, (Throwable)throwable);
    }

    public boolean isTerminated() {
        boolean bl = this.get() == ExceptionHelper.TERMINATED;
        return bl;
    }

    public Throwable terminate() {
        return ExceptionHelper.terminate((AtomicReference)this);
    }
}
