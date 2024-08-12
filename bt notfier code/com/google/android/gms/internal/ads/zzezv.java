/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbfr
 *  com.google.android.gms.internal.ads.zzezw
 *  com.google.android.gms.internal.ads.zzfid
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzezw;
import com.google.android.gms.internal.ads.zzfid;

final class zzezv
extends zzfid {
    final zzbfr zza;
    final zzezw zzb;

    zzezv(zzezw zzezw2, zzbfr zzbfr2) {
        this.zzb = zzezw2;
        this.zza = zzbfr2;
    }

    public final void zzu() {
        if (zzezw.zzw((zzezw)this.zzb) == null) return;
        try {
            this.zza.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
    }
}
