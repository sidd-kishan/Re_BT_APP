/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmi;
import javax.annotation.CheckForNull;

public final class zzflx {
    public static void zza(boolean bl, @CheckForNull Object object) {
        if (!bl) throw new IllegalArgumentException((String)object);
    }

    public static void zzb(boolean bl, @CheckForNull Object object) {
        if (!bl) throw new IllegalStateException((String)object);
    }

    public static <T> T zzc(@CheckForNull T t, @CheckForNull Object object) {
        if (t == null) throw new NullPointerException((String)object);
        return t;
    }

    public static <T> T zzd(@CheckForNull T t, String string, @CheckForNull Object object) {
        if (t == null) throw new NullPointerException(zzfmi.zzd((String)string, (Object[])new Object[]{object}));
        return t;
    }

    public static int zze(int n, int n2, String charSequence) {
        if (n >= 0) {
            if (n < n2) return n;
        }
        if (n >= 0) {
            if (n2 < 0) {
                charSequence = new StringBuilder(26);
                ((StringBuilder)charSequence).append("negative size: ");
                ((StringBuilder)charSequence).append(n2);
                throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
            }
            charSequence = zzfmi.zzd((String)"%s (%s) must be less than size (%s)", (Object[])new Object[]{"index", n, n2});
        } else {
            charSequence = zzfmi.zzd((String)"%s (%s) must not be negative", (Object[])new Object[]{"index", n});
        }
        throw new IndexOutOfBoundsException((String)charSequence);
    }

    public static int zzf(int n, int n2, String string) {
        if (n < 0) throw new IndexOutOfBoundsException(zzflx.zzh(n, n2, "index"));
        if (n > n2) throw new IndexOutOfBoundsException(zzflx.zzh(n, n2, "index"));
        return n;
    }

    public static void zzg(int n, int n2, int n3) {
        if (n >= 0 && n2 >= n) {
            if (n2 <= n3) return;
        }
        String string = n >= 0 && n <= n3 ? (n2 >= 0 && n2 <= n3 ? zzfmi.zzd((String)"end index (%s) must not be less than start index (%s)", (Object[])new Object[]{n2, n}) : zzflx.zzh(n2, n3, "end index")) : zzflx.zzh(n, n3, "start index");
        throw new IndexOutOfBoundsException(string);
    }

    private static String zzh(int n, int n2, String charSequence) {
        if (n < 0) {
            return zzfmi.zzd((String)"%s (%s) must not be negative", (Object[])new Object[]{charSequence, n});
        }
        if (n2 >= 0) {
            return zzfmi.zzd((String)"%s (%s) must not be greater than size (%s)", (Object[])new Object[]{charSequence, n, n2});
        }
        charSequence = new StringBuilder(26);
        ((StringBuilder)charSequence).append("negative size: ");
        ((StringBuilder)charSequence).append(n2);
        throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
    }
}
