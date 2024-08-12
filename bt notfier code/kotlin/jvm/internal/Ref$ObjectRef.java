/*
 * Decompiled with CFR 0.152.
 */
package kotlin.jvm.internal;

import java.io.Serializable;

public static final class Ref.ObjectRef<T>
implements Serializable {
    public T element;

    public String toString() {
        return String.valueOf(this.element);
    }
}
