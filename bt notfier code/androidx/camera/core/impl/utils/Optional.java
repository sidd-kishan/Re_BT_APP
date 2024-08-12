/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.Absent
 *  androidx.camera.core.impl.utils.Present
 *  androidx.core.util.Preconditions
 *  androidx.core.util.Supplier
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.Absent;
import androidx.camera.core.impl.utils.Present;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;
import java.io.Serializable;

public abstract class Optional<T>
implements Serializable {
    private static final long serialVersionUID = 0L;

    Optional() {
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(T object) {
        object = object == null ? Optional.absent() : new Present(object);
        return object;
    }

    public static <T> Optional<T> of(T t) {
        return new Present(Preconditions.checkNotNull(t));
    }

    public abstract boolean equals(Object var1);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> var1);

    public abstract T or(Supplier<? extends T> var1);

    public abstract T or(T var1);

    public abstract T orNull();

    public abstract String toString();
}
