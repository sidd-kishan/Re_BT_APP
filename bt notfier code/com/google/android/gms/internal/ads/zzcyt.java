/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzazu
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzcfy
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdgj
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzazu;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzcfy;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdgj;
import com.google.android.gms.internal.ads.zzfal;

public final class zzcyt
implements zzdcq,
zzbcv,
zzddx,
zzdbw,
zzdbc,
zzdgj {
    private final Clock zza;
    private final zzcfy zzb;

    public zzcyt(Clock clock, zzcfy zzcfy2) {
        this.zza = clock;
        this.zzb = zzcfy2;
    }

    public final void onAdClicked() {
        this.zzb.zzg();
    }

    public final void zza(zzbdg zzbdg2) {
        this.zzb.zzb(zzbdg2);
    }

    public final void zzbG(zzcbj zzcbj2) {
    }

    public final void zzc(zzazu zzazu2) {
        this.zzb.zzc();
    }

    public final void zzd(zzazu zzazu2) {
    }

    public final void zze(zzazu zzazu2) {
        this.zzb.zzd();
    }

    public final void zzf() {
        this.zzb.zzi(true);
    }

    public final void zzg() {
        this.zzb.zzf();
    }

    public final void zzh() {
    }

    public final void zzi() {
        this.zzb.zzh();
    }

    public final void zzj() {
    }

    public final void zzk(zzcbz zzcbz2, String string, String string2) {
    }

    public final void zzl() {
    }

    public final void zzm() {
    }

    public final void zzn(boolean bl) {
    }

    public final void zzo(boolean bl) {
    }

    public final void zzp() {
    }

    public final void zzq(zzfal zzfal2) {
        this.zzb.zze(this.zza.elapsedRealtime());
    }

    public final String zzr() {
        return this.zzb.zzk();
    }
}
