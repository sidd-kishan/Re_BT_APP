/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbgt
 *  com.google.android.gms.internal.ads.zzezq
 *  com.google.android.gms.internal.ads.zzfid
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzezq;
import com.google.android.gms.internal.ads.zzfid;

final class zzezo
extends zzfid {
    final zzbgt zza;
    final zzezq zzb;

    zzezo(zzezq zzezq2, zzbgt zzbgt2) {
        this.zzb = zzezq2;
        this.zza = zzbgt2;
    }

    public final void zzu() {
        if (zzezq.zzr((zzezq)this.zzb) == null) return;
        try {
            this.zza.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
    }
}
