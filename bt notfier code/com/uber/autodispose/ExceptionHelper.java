/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.ExceptionHelper$Termination
 *  io.reactivex.exceptions.CompositeException
 */
package com.uber.autodispose;

import com.uber.autodispose.ExceptionHelper;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

final class ExceptionHelper {
    private static final Throwable TERMINATED = new Termination();

    private ExceptionHelper() {
        throw new IllegalStateException("No instances!");
    }

    static boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable throwable) {
        Throwable throwable2;
        Throwable throwable3;
        do {
            if ((throwable3 = atomicReference.get()) != TERMINATED) continue;
            return false;
        } while (!atomicReference.compareAndSet(throwable3, throwable2 = throwable3 == null ? throwable : new CompositeException(new Throwable[]{throwable3, throwable})));
        return true;
    }

    static Throwable terminate(AtomicReference<Throwable> atomicReference) {
        Throwable throwable = atomicReference.get();
        Throwable throwable2 = TERMINATED;
        Throwable throwable3 = throwable;
        if (throwable == throwable2) return throwable3;
        throwable3 = atomicReference.getAndSet(throwable2);
        return throwable3;
    }
}
