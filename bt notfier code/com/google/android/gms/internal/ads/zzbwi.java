/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.mediation.Adapter
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbvl
 *  com.google.android.gms.internal.ads.zzcck
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzccp
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbvl;
import com.google.android.gms.internal.ads.zzcck;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzccp;

public final class zzbwi
extends zzbvl {
    private final Adapter zza;
    private final zzcck zzb;

    zzbwi(Adapter adapter, zzcck zzcck2) {
        this.zza = adapter;
        this.zzb = zzcck2;
    }

    public final void zze() throws RemoteException {
        zzcck zzcck2 = this.zzb;
        if (zzcck2 == null) return;
        zzcck2.zzl(ObjectWrapper.wrap((Object)this.zza));
    }

    public final void zzf() throws RemoteException {
        zzcck zzcck2 = this.zzb;
        if (zzcck2 == null) return;
        zzcck2.zzj(ObjectWrapper.wrap((Object)this.zza));
    }

    public final void zzg(int n) throws RemoteException {
        zzcck zzcck2 = this.zzb;
        if (zzcck2 == null) return;
        zzcck2.zzm(ObjectWrapper.wrap((Object)this.zza), n);
    }

    public final void zzh() throws RemoteException {
    }

    public final void zzi() throws RemoteException {
        zzcck zzcck2 = this.zzb;
        if (zzcck2 == null) return;
        zzcck2.zzh(ObjectWrapper.wrap((Object)this.zza));
    }

    public final void zzj() throws RemoteException {
        zzcck zzcck2 = this.zzb;
        if (zzcck2 == null) return;
        zzcck2.zzg(ObjectWrapper.wrap((Object)this.zza));
    }

    public final void zzk() throws RemoteException {
    }

    public final void zzl(String string, String string2) throws RemoteException {
    }

    public final void zzm(zzbnb zzbnb2, String string) throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzo() throws RemoteException {
        zzcck zzcck2 = this.zzb;
        if (zzcck2 == null) return;
        zzcck2.zzi(ObjectWrapper.wrap((Object)this.zza));
    }

    public final void zzp(zzccl zzccl2) throws RemoteException {
    }

    public final void zzq() throws RemoteException {
    }

    public final void zzr(zzccp zzccp2) throws RemoteException {
        zzcck zzcck2 = this.zzb;
        if (zzcck2 == null) return;
        zzcck2.zzk(ObjectWrapper.wrap((Object)this.zza), new zzccl(zzccp2.zze(), zzccp2.zzf()));
    }

    public final void zzs(int n) throws RemoteException {
    }

    public final void zzt() throws RemoteException {
        zzcck zzcck2 = this.zzb;
        if (zzcck2 == null) return;
        zzcck2.zzo(ObjectWrapper.wrap((Object)this.zza));
    }

    public final void zzu() throws RemoteException {
    }

    public final void zzv(String string) {
    }

    public final void zzw(int n, String string) throws RemoteException {
    }

    public final void zzx(zzbcz zzbcz2) throws RemoteException {
    }

    public final void zzy(zzbcz zzbcz2) {
    }
}
