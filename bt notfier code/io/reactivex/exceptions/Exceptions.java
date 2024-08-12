/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.util.ExceptionHelper
 */
package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;

public final class Exceptions {
    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException propagate(Throwable throwable) {
        throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
    }

    public static void throwIfFatal(Throwable throwable) {
        if (throwable instanceof VirtualMachineError) throw (VirtualMachineError)throwable;
        if (throwable instanceof ThreadDeath) throw (ThreadDeath)throwable;
        if (throwable instanceof LinkageError) throw (LinkageError)throwable;
    }
}
