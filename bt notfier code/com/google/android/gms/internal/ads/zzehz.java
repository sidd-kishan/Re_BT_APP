/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbxj
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzeia
 *  com.google.android.gms.internal.ads.zzeib
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbxj;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzeia;
import com.google.android.gms.internal.ads.zzeib;

final class zzehz
extends zzbxj {
    private final zzeef<zzbxn, zzefy> zza;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzehz(zzeib zzeib2, zzeef zzeef2, zzeia zzeia2) {
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
