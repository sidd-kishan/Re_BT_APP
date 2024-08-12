/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.rtb.SignalCallbacks
 *  com.google.android.gms.internal.ads.zzbxq
 *  com.google.android.gms.internal.ads.zzbxy
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.google.android.gms.internal.ads.zzbxq;
import com.google.android.gms.internal.ads.zzbxy;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbxw
implements SignalCallbacks {
    final zzbxq zza;

    zzbxw(zzbxy zzbxy2, zzbxq zzbxq2) {
        this.zza = zzbxq2;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void onFailure(String string) {
        try {
            this.zza.zzf(string);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void onSuccess(String string) {
        try {
            this.zza.zze(string);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }
}
