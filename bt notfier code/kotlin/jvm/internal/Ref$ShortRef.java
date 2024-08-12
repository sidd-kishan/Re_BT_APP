/*
 * Decompiled with CFR 0.152.
 */
package kotlin.jvm.internal;

import java.io.Serializable;

public static final class Ref.ShortRef
implements Serializable {
    public short element;

    public String toString() {
        return String.valueOf(this.element);
    }
}
