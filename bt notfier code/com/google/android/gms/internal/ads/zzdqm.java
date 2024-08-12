/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbmx
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzdmm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbmx;
import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzdmm;
import java.util.List;

public final class zzdqm
extends zzbmx {
    private final String zza;
    private final zzdmh zzb;
    private final zzdmm zzc;

    public zzdqm(String string, zzdmh zzdmh2, zzdmm zzdmm2) {
        this.zza = string;
        this.zzb = zzdmh2;
        this.zzc = zzdmm2;
    }

    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.wrap((Object)this.zzb);
    }

    public final String zzc() throws RemoteException {
        return this.zzc.zzz();
    }

    public final List<?> zzd() throws RemoteException {
        return this.zzc.zzA();
    }

    public final String zze() throws RemoteException {
        return this.zzc.zzE();
    }

    public final zzbmh zzf() throws RemoteException {
        return this.zzc.zzP();
    }

    public final String zzg() throws RemoteException {
        return this.zzc.zzG();
    }

    public final String zzh() throws RemoteException {
        return this.zzc.zzO();
    }

    public final Bundle zzi() throws RemoteException {
        return this.zzc.zzF();
    }

    public final void zzj() throws RemoteException {
        this.zzb.zzT();
    }

    public final zzbhc zzk() throws RemoteException {
        return this.zzc.zzw();
    }

    public final void zzl(Bundle bundle) throws RemoteException {
        this.zzb.zzf(bundle);
    }

    public final boolean zzm(Bundle bundle) throws RemoteException {
        return this.zzb.zzg(bundle);
    }

    public final void zzn(Bundle bundle) throws RemoteException {
        this.zzb.zzh(bundle);
    }

    public final zzblz zzo() throws RemoteException {
        return this.zzc.zzx();
    }

    public final IObjectWrapper zzp() throws RemoteException {
        return this.zzc.zzJ();
    }

    public final String zzq() throws RemoteException {
        return this.zza;
    }
}
