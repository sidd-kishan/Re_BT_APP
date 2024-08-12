/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import java.io.IOException;

public class zzoi
implements zznv {
    private final zznv zza;

    public zzoi(zznv zznv2) {
        this.zza = zznv2;
    }

    public final boolean zza(byte[] byArray, int n, int n2, boolean bl) throws IOException {
        return this.zza.zza(byArray, 0, 8, true);
    }

    public final void zzb(byte[] byArray, int n, int n2) throws IOException {
        ((zznp)this.zza).zza(byArray, n, n2, false);
    }

    public final int zzc(int n) throws IOException {
        throw null;
    }

    public final void zze(int n) throws IOException {
        ((zznp)this.zza).zzd(n, false);
    }

    public final int zzf(byte[] byArray, int n, int n2) throws IOException {
        throw null;
    }

    public final int zzg(byte[] byArray, int n, int n2) throws IOException {
        return this.zza.zzg(byArray, n, n2);
    }

    public final boolean zzh(byte[] byArray, int n, int n2, boolean bl) throws IOException {
        return this.zza.zzh(byArray, 0, 8, true);
    }

    public final void zzi(byte[] byArray, int n, int n2) throws IOException {
        ((zznp)this.zza).zzh(byArray, n, n2, false);
    }

    public final void zzk(int n) throws IOException {
        ((zznp)this.zza).zzj(n, false);
    }

    public final void zzl() {
        this.zza.zzl();
    }

    public long zzm() {
        return this.zza.zzm();
    }

    public long zzn() {
        return this.zza.zzn();
    }

    public long zzo() {
        return this.zza.zzo();
    }
}
