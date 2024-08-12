/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfub
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfub;
import java.util.Arrays;

final class zzfuc
implements Comparable<zzfuc> {
    private final byte[] zza;

    /* synthetic */ zzfuc(byte[] byArray, zzfub zzfub2) {
        this.zza = Arrays.copyOf(byArray, byArray.length);
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzfuc)) {
            return false;
        }
        object = (zzfuc)object;
        return Arrays.equals(this.zza, ((zzfuc)object).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        byte[] byArray = this.zza;
        int n = byArray.length;
        StringBuilder stringBuilder = new StringBuilder(n + n);
        int n2 = 0;
        while (n2 < n) {
            int n3 = byArray[n2] & 0xFF;
            stringBuilder.append("0123456789abcdef".charAt(n3 >> 4));
            stringBuilder.append("0123456789abcdef".charAt(n3 & 0xF));
            ++n2;
        }
        return stringBuilder.toString();
    }
}
