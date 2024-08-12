/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.ads.AdRequest$ErrorCode
 *  com.google.android.gms.internal.ads.zzbww
 *  com.google.android.gms.internal.ads.zzbwx
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.ads.zzbww;
import com.google.android.gms.internal.ads.zzbwx;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbwp
implements Runnable {
    final AdRequest.ErrorCode zza;
    final zzbww zzb;

    zzbwp(zzbww zzbww2, AdRequest.ErrorCode errorCode) {
        this.zzb = zzbww2;
        this.zza = errorCode;
    }

    @Override
    public final void run() {
        try {
            zzbww.zza((zzbww)this.zzb).zzg(zzbwx.zza((AdRequest.ErrorCode)this.zza));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
