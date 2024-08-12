/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.ObjectsCompat
 */
package androidx.core.os;

import androidx.core.util.ObjectsCompat;

public class OperationCanceledException
extends RuntimeException {
    public OperationCanceledException() {
        this((String)null);
    }

    public OperationCanceledException(String string) {
        super(ObjectsCompat.toString((Object)string, (String)"The operation has been canceled."));
    }
}
