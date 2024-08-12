/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;

public final class zzdc {
    public static final zzdc zza = new zzdc(-1, -1, -1);
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzdc(int n, int n2, int n3) {
        this.zzb = n;
        this.zzc = n2;
        this.zzd = n3;
        n = zzamq.zzP((int)n3) ? zzamq.zzS((int)n3, (int)n2) : -1;
        this.zze = n;
    }

    public final String toString() {
        int n = this.zzb;
        int n2 = this.zzc;
        int n3 = this.zzd;
        StringBuilder stringBuilder = new StringBuilder(83);
        stringBuilder.append("AudioFormat[sampleRate=");
        stringBuilder.append(n);
        stringBuilder.append(", channelCount=");
        stringBuilder.append(n2);
        stringBuilder.append(", encoding=");
        stringBuilder.append(n3);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
