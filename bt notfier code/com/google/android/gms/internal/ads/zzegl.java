/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbxd
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzegm
 *  com.google.android.gms.internal.ads.zzegn
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbxd;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzegm;
import com.google.android.gms.internal.ads.zzegn;

final class zzegl
extends zzbxd {
    private final zzeef<zzbxn, zzefy> zza;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzegl(zzegn zzegn2, zzeef zzeef2, zzegm zzegm2) {
        this.zza = zzeef2;
    }

    public final void zze() throws RemoteException {
        ((zzefy)this.zza.zzc).zzj();
    }

    public final void zzf(String string) throws RemoteException {
        ((zzefy)this.zza.zzc).zzw(0, string);
    }

    public final void zzg(zzbcz zzbcz2) throws RemoteException {
        ((zzefy)this.zza.zzc).zzx(zzbcz2);
    }
}
