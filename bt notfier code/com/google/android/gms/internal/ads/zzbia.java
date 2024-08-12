/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbff
 *  com.google.android.gms.internal.ads.zzbhy
 *  com.google.android.gms.internal.ads.zzbhz
 *  com.google.android.gms.internal.ads.zzbib
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbhz;
import com.google.android.gms.internal.ads.zzbib;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbia
extends zzbff {
    final zzbib zza;

    /* synthetic */ zzbia(zzbib zzbib2, zzbhy zzbhy2) {
        this.zza = zzbib2;
    }

    public final void zze(zzbdg zzbdg2) throws RemoteException {
        this.zzi(zzbdg2, 1);
    }

    public final String zzf() throws RemoteException {
        return null;
    }

    public final boolean zzg() throws RemoteException {
        return false;
    }

    public final String zzh() throws RemoteException {
        return null;
    }

    public final void zzi(zzbdg zzbdg2, int n) throws RemoteException {
        zzcgt.zzf((String)"This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzcgm.zza.post((Runnable)new zzbhz(this));
    }
}
