/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbvv
 *  com.google.android.gms.internal.ads.zzbxg
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzehb
 *  com.google.android.gms.internal.ads.zzehc
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzbxg;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzehb;
import com.google.android.gms.internal.ads.zzehc;

final class zzeha
extends zzbxg {
    final zzehc zza;
    private final zzeef<zzbxn, zzefy> zzb;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzeha(zzehc zzehc2, zzeef zzeef2, zzehb zzehb2) {
        this.zza = zzehc2;
        this.zzb = zzeef2;
    }

    public final void zze(zzbvv zzbvv2) throws RemoteException {
        zzehc.zzc((zzehc)this.zza, (zzbvv)zzbvv2);
        ((zzefy)this.zzb.zzc).zzj();
    }

    public final void zzf(String string) throws RemoteException {
        ((zzefy)this.zzb.zzc).zzw(0, string);
    }

    public final void zzg(zzbcz zzbcz2) throws RemoteException {
        ((zzefy)this.zzb.zzc).zzx(zzbcz2);
    }
}
