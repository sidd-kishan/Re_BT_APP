/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzaup {
    public static void zza(boolean bl) {
        if (!bl) throw new IllegalArgumentException();
    }

    public static void zzb(boolean bl, Object object) {
        if (!bl) throw new IllegalArgumentException((String)object);
    }

    public static int zzc(int n, int n2, int n3) {
        if (n < 0) throw new IndexOutOfBoundsException();
        if (n >= n3) throw new IndexOutOfBoundsException();
        return 0;
    }

    public static void zzd(boolean bl) {
        if (!bl) throw new IllegalStateException();
    }

    public static void zze(boolean bl, Object object) {
        if (!bl) throw new IllegalStateException((String)object);
    }

    public static String zzf(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException();
        return string;
    }
}
