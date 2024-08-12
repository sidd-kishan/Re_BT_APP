/*
 * Decompiled with CFR 0.152.
 */
package com.uber.autodispose;

final class AutoDisposeUtil {
    private AutoDisposeUtil() {
        throw new InstantiationError();
    }

    static <T> T checkNotNull(T t, String string) {
        if (t == null) throw new NullPointerException(string);
        return t;
    }
}
