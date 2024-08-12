/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.ads.mediation;

public final class VersionInfo {
    private final int zza;
    private final int zzb;
    private final int zzc;

    public VersionInfo(int n, int n2, int n3) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = n3;
    }

    public int getMajorVersion() {
        return this.zza;
    }

    public int getMicroVersion() {
        return this.zzc;
    }

    public int getMinorVersion() {
        return this.zzb;
    }
}
