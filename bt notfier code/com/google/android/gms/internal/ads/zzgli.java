/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzgli {
    public static <T> T zza(T t, String string) {
        if (t == null) throw new NullPointerException(string);
        return t;
    }

    public static <T> T zzb(T t) {
        if (t == null) throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        return t;
    }

    public static <T> void zzc(T t, Class<T> clazz) {
        if (t == null) throw new IllegalStateException(String.valueOf(clazz.getCanonicalName()).concat(" must be set"));
    }
}
