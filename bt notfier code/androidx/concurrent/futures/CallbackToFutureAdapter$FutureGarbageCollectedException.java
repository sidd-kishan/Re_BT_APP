/*
 * Decompiled with CFR 0.152.
 */
package androidx.concurrent.futures;

static final class CallbackToFutureAdapter.FutureGarbageCollectedException
extends Throwable {
    CallbackToFutureAdapter.FutureGarbageCollectedException(String string) {
        super(string);
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
