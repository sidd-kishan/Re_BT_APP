/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.consent_sdk;

public final class zzcu {
    public static <T> T zza(T t) {
        if (t == null) throw null;
        return t;
    }

    public static <T> T zza(T t, String string) {
        if (t == null) throw new NullPointerException(string);
        return t;
    }

    public static <T> void zza(T t, Class<T> clazz) {
        if (t == null) throw new IllegalStateException(String.valueOf(clazz.getCanonicalName()).concat(" must be set"));
    }
}
