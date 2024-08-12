/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.Optional
 *  androidx.core.util.Preconditions
 *  androidx.core.util.Supplier
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.Optional;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

final class Present<T>
extends Optional<T> {
    private static final long serialVersionUID = 0L;
    private final T mReference;

    Present(T t) {
        this.mReference = t;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Present)) return false;
        object = (Present)((Object)object);
        return this.mReference.equals(((Present)((Object)object)).mReference);
    }

    public T get() {
        return this.mReference;
    }

    public int hashCode() {
        return this.mReference.hashCode() + 1502476572;
    }

    public boolean isPresent() {
        return true;
    }

    public Optional<T> or(Optional<? extends T> optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    public T or(Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.mReference;
    }

    public T or(T t) {
        Preconditions.checkNotNull(t, (Object)"use Optional.orNull() instead of Optional.or(null)");
        return this.mReference;
    }

    public T orNull() {
        return this.mReference;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Optional.of(");
        stringBuilder.append(this.mReference);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
