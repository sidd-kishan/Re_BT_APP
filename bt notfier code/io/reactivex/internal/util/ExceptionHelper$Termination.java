/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.util;

static final class ExceptionHelper.Termination
extends Throwable {
    private static final long serialVersionUID = -4649703670690200604L;

    ExceptionHelper.Termination() {
        super("No further exceptions");
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
