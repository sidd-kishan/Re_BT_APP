/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.VideoController$VideoLifecycleCallbacks
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbhf
 *  com.google.android.gms.internal.ads.zzdmm
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzdmm;

public final class zzdrr
extends VideoController.VideoLifecycleCallbacks {
    private final zzdmm zza;

    public zzdrr(zzdmm zzdmm2) {
        this.zza = zzdmm2;
    }

    private static zzbhf zza(zzdmm zzdmm2) {
        if ((zzdmm2 = zzdmm2.zzw()) == null) {
            return null;
        }
        try {
            zzdmm2 = zzdmm2.zzo();
            return zzdmm2;
        }
        catch (RemoteException remoteException) {
            return null;
        }
    }

    public final void onVideoEnd() {
        zzbhf zzbhf2 = zzdrr.zza(this.zza);
        if (zzbhf2 == null) {
            return;
        }
        try {
            zzbhf2.zzh();
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzj((String)"Unable to call onVideoEnd()", (Throwable)remoteException);
            return;
        }
    }

    public final void onVideoPause() {
        zzbhf zzbhf2 = zzdrr.zza(this.zza);
        if (zzbhf2 == null) {
            return;
        }
        try {
            zzbhf2.zzg();
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzj((String)"Unable to call onVideoEnd()", (Throwable)remoteException);
            return;
        }
    }

    public final void onVideoStart() {
        zzbhf zzbhf2 = zzdrr.zza(this.zza);
        if (zzbhf2 == null) {
            return;
        }
        try {
            zzbhf2.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzj((String)"Unable to call onVideoEnd()", (Throwable)remoteException);
            return;
        }
    }
}
