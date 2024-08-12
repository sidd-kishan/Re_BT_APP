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

final class Absent<T>
extends Optional<T> {
    static final Absent<Object> sInstance = new Absent();
    private static final long serialVersionUID = 0L;

    private Absent() {
    }

    private Object readResolve() {
        return sInstance;
    }

    static <T> Optional<T> withType() {
        return sInstance;
    }

    public boolean equals(Object object) {
        boolean bl = object == this;
        return bl;
    }

    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public int hashCode() {
        return 2040732332;
    }

    public boolean isPresent() {
        return false;
    }

    public Optional<T> or(Optional<? extends T> optional) {
        return (Optional)Preconditions.checkNotNull(optional);
    }

    public T or(Supplier<? extends T> supplier) {
        return (T)Preconditions.checkNotNull((Object)supplier.get(), (Object)"use Optional.orNull() instead of a Supplier that returns null");
    }

    public T or(T t) {
        return (T)Preconditions.checkNotNull(t, (Object)"use Optional.orNull() instead of Optional.or(null)");
    }

    public T orNull() {
        return null;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
