/*
 * Decompiled with CFR 0.152.
 */
package kotlin.jvm.internal;

import java.io.Serializable;

public static final class Ref.ByteRef
implements Serializable {
    public byte element;

    public String toString() {
        return String.valueOf(this.element);
    }
}
