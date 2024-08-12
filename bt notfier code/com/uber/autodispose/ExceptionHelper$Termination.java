/*
 * Decompiled with CFR 0.152.
 */
package com.uber.autodispose;

static final class ExceptionHelper.Termination
extends Throwable {
    ExceptionHelper.Termination() {
        super("No further exceptions");
    }

    /*
     * Converted monitor instructions to comments
     */
    @Override
    public Throwable fillInStackTrace() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return this;
    }
}
