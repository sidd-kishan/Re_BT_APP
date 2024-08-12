/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  android.media.AudioTrack$StreamEventCallback
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzem
 *  com.google.android.gms.internal.ads.zzen
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzem;
import com.google.android.gms.internal.ads.zzen;

final class zzel
extends AudioTrack.StreamEventCallback {
    final zzen zza;
    final zzem zzb;

    zzel(zzem zzem2, zzen zzen2) {
        this.zzb = zzem2;
        this.zza = zzen2;
    }

    public final void onDataRequest(AudioTrack audioTrack, int n) {
        boolean bl = audioTrack == zzen.zzx((zzen)this.zzb.zza);
        zzakt.zzd((boolean)bl);
        if (zzen.zzw((zzen)this.zzb.zza) == null) return;
        if (!zzen.zzy((zzen)this.zzb.zza)) return;
        zzen.zzw((zzen)this.zzb.zza).zza();
    }

    public final void onTearDown(AudioTrack audioTrack) {
        boolean bl = audioTrack == zzen.zzx((zzen)this.zzb.zza);
        zzakt.zzd((boolean)bl);
        if (zzen.zzw((zzen)this.zzb.zza) == null) return;
        if (!zzen.zzy((zzen)this.zzb.zza)) return;
        zzen.zzw((zzen)this.zzb.zza).zza();
    }
}
