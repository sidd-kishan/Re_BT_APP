/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils.futures;

class AbstractFuture.Failure.1
extends Throwable {
    AbstractFuture.Failure.1(String string) {
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
