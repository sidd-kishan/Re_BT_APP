/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zznh
 *  com.google.android.gms.internal.ads.zzni
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zznh;
import com.google.android.gms.internal.ads.zzni;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;

public final class zznf
implements zzot {
    private final zzni zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;

    public zznf(zzni zzni2, long l, long l2, long l3, long l4, long l5, long l6) {
        this.zza = zzni2;
        this.zzb = l;
        this.zzc = l3;
        this.zzd = l4;
        this.zze = l5;
        this.zzf = l6;
    }

    static /* synthetic */ long zza(zznf zznf2) {
        return zznf2.zzc;
    }

    static /* synthetic */ long zzb(zznf zznf2) {
        return zznf2.zzd;
    }

    static /* synthetic */ long zzc(zznf zznf2) {
        return zznf2.zze;
    }

    static /* synthetic */ long zzd(zznf zznf2) {
        return zznf2.zzf;
    }

    public final boolean zze() {
        return true;
    }

    public final zzor zzf(long l) {
        zzou zzou2 = new zzou(l, zznh.zza((long)this.zza.zza(l), (long)0L, (long)this.zzc, (long)this.zzd, (long)this.zze, (long)this.zzf));
        return new zzor(zzou2, zzou2);
    }

    public final long zzg() {
        return this.zzb;
    }

    public final long zzh(long l) {
        return this.zza.zza(l);
    }
}
