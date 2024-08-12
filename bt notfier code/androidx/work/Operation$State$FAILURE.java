/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Operation$State
 */
package androidx.work;

import androidx.work.Operation;

public static final class Operation.State.FAILURE
extends Operation.State {
    private final Throwable mThrowable;

    public Operation.State.FAILURE(Throwable throwable) {
        this.mThrowable = throwable;
    }

    public Throwable getThrowable() {
        return this.mThrowable;
    }

    public String toString() {
        return String.format("FAILURE (%s)", this.mThrowable.getMessage());
    }
}
