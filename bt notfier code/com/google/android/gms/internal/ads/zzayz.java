/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.InputStream;

public final class zzayz {
    private final InputStream zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    private zzayz(InputStream inputStream, boolean bl, boolean bl2, long l, boolean bl3) {
        this.zza = inputStream;
        this.zzb = bl;
        this.zzc = bl2;
        this.zzd = l;
        this.zze = bl3;
    }

    public static zzayz zza(InputStream inputStream, boolean bl, boolean bl2, long l, boolean bl3) {
        return new zzayz(inputStream, bl, bl2, l, bl3);
    }

    public final InputStream zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zzc;
    }

    public final long zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zze;
    }
}
