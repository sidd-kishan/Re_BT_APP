/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.ExceptionHelper
 */
package com.uber.autodispose;

import com.uber.autodispose.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

final class AtomicThrowable
extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    AtomicThrowable() {
    }

    public boolean addThrowable(Throwable throwable) {
        return ExceptionHelper.addThrowable((AtomicReference)this, (Throwable)throwable);
    }

    public Throwable terminate() {
        return ExceptionHelper.terminate((AtomicReference)this);
    }
}
