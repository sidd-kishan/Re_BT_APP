/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzm
 *  org.checkerframework.checker.nullness.compatqual.NullableDecl
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzm;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzl {
    public static int zza(int n, int n2, @NullableDecl String charSequence) {
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
            charSequence = zzm.zza((String)"%s (%s) must be less than size (%s)", (Object[])new Object[]{"index", n, n2});
        } else {
            charSequence = zzm.zza((String)"%s (%s) must not be negative", (Object[])new Object[]{"index", n});
        }
        throw new IndexOutOfBoundsException((String)charSequence);
    }

    public static int zzb(int n, int n2, @NullableDecl String string) {
        if (n < 0) throw new IndexOutOfBoundsException(zzl.zzd(n, n2, "index"));
        if (n > n2) throw new IndexOutOfBoundsException(zzl.zzd(n, n2, "index"));
        return n;
    }

    public static void zzc(int n, int n2, int n3) {
        if (n >= 0 && n2 >= n) {
            if (n2 <= n3) return;
        }
        String string = n >= 0 && n <= n3 ? (n2 >= 0 && n2 <= n3 ? zzm.zza((String)"end index (%s) must not be less than start index (%s)", (Object[])new Object[]{n2, n}) : zzl.zzd(n2, n3, "end index")) : zzl.zzd(n, n3, "start index");
        throw new IndexOutOfBoundsException(string);
    }

    private static String zzd(int n, int n2, @NullableDecl String charSequence) {
        if (n < 0) {
            return zzm.zza((String)"%s (%s) must not be negative", (Object[])new Object[]{charSequence, n});
        }
        if (n2 >= 0) {
            return zzm.zza((String)"%s (%s) must not be greater than size (%s)", (Object[])new Object[]{charSequence, n, n2});
        }
        charSequence = new StringBuilder(26);
        ((StringBuilder)charSequence).append("negative size: ");
        ((StringBuilder)charSequence).append(n2);
        throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
    }
}
