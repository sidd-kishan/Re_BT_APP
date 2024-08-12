/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

public final class zzakt {
    @Pure
    public static void zza(boolean bl) {
        if (!bl) throw new IllegalArgumentException();
    }

    @Pure
    public static void zzb(boolean bl, Object object) {
        if (!bl) throw new IllegalArgumentException(String.valueOf(object));
    }

    @Pure
    public static int zzc(int n, int n2, int n3) {
        if (n < 0) throw new IndexOutOfBoundsException();
        if (n >= n3) throw new IndexOutOfBoundsException();
        return n;
    }

    @Pure
    public static void zzd(boolean bl) {
        if (!bl) throw new IllegalStateException();
    }

    @EnsuresNonNull(value={"#1"})
    @Pure
    public static <T> T zze(T t) {
        if (t == null) throw new IllegalStateException();
        return t;
    }

    @EnsuresNonNull(value={"#1"})
    @Pure
    public static String zzf(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException();
        return string;
    }
}
