/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

public final class $Gson$Preconditions {
    private $Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean bl) {
        if (!bl) throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T t) {
        if (t == null) throw null;
        return t;
    }
}
