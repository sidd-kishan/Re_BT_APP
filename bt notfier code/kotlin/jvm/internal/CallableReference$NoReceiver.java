/*
 * Decompiled with CFR 0.152.
 */
package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;

private static class CallableReference.NoReceiver
implements Serializable {
    private static final CallableReference.NoReceiver INSTANCE = new CallableReference.NoReceiver();

    private CallableReference.NoReceiver() {
    }

    static /* synthetic */ CallableReference.NoReceiver access$000() {
        return INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
