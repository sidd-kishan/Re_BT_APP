/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.ads;

public final class AdValue {
    private final int zza;
    private final String zzb;
    private final long zzc;

    private AdValue(int n, String string, long l) {
        this.zza = n;
        this.zzb = string;
        this.zzc = l;
    }

    public static AdValue zza(int n, String string, long l) {
        return new AdValue(n, string, l);
    }

    public String getCurrencyCode() {
        return this.zzb;
    }

    public int getPrecisionType() {
        return this.zza;
    }

    public long getValueMicros() {
        return this.zzc;
    }
}
