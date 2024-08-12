/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbgt
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbii
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzccr
 *  com.google.android.gms.internal.ads.zzccv
 *  com.google.android.gms.internal.ads.zzccz
 *  com.google.android.gms.internal.ads.zzcda
 *  com.google.android.gms.internal.ads.zzcdg
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzccr;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzccz;
import com.google.android.gms.internal.ads.zzcda;
import com.google.android.gms.internal.ads.zzcdg;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbij
extends zzccr {
    private static void zzr(zzccz zzccz2) {
        zzcgt.zzf((String)"This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzcgm.zza.post((Runnable)new zzbii(zzccz2));
    }

    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzc(zzbdg zzbdg2, zzccz zzccz2) throws RemoteException {
        zzbij.zzr(zzccz2);
    }

    public final void zzd(zzbdg zzbdg2, zzccz zzccz2) throws RemoteException {
        zzbij.zzr(zzccz2);
    }

    public final void zze(zzccv zzccv2) throws RemoteException {
    }

    public final void zzf(zzbgt zzbgt2) throws RemoteException {
    }

    public final Bundle zzg() throws RemoteException {
        return new Bundle();
    }

    public final void zzh(zzcdg zzcdg2) {
    }

    public final boolean zzi() throws RemoteException {
        return false;
    }

    public final String zzj() throws RemoteException {
        return "";
    }

    public final void zzk(IObjectWrapper iObjectWrapper, boolean bl) {
    }

    public final zzccp zzl() {
        return null;
    }

    public final zzbgz zzm() {
        return null;
    }

    public final void zzn(zzbgw zzbgw2) {
    }

    public final void zzo(boolean bl) {
    }

    public final void zzp(zzcda zzcda2) throws RemoteException {
    }
}
