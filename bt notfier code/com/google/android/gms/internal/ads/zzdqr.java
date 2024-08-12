/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgi
 *  com.google.android.gms.internal.ads.zzbgm
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbob
 *  com.google.android.gms.internal.ads.zzbod
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzdmm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzdmm;
import java.util.Collections;
import java.util.List;

public final class zzdqr
extends zzbod {
    private final String zza;
    private final zzdmh zzb;
    private final zzdmm zzc;

    public zzdqr(String string, zzdmh zzdmh2, zzdmm zzdmm2) {
        this.zza = string;
        this.zzb = zzdmh2;
        this.zzc = zzdmm2;
    }

    public final boolean zzA() throws RemoteException {
        if (this.zzc.zzC().isEmpty()) return false;
        if (this.zzc.zzD() == null) return false;
        return true;
    }

    public final void zzB(zzbgm zzbgm2) throws RemoteException {
        this.zzb.zzx(zzbgm2);
    }

    public final void zzC(zzbgi zzbgi2) throws RemoteException {
        this.zzb.zzy(zzbgi2);
    }

    public final void zzD() {
        this.zzb.zzz();
    }

    public final void zzE() {
        this.zzb.zzA();
    }

    public final zzbme zzF() throws RemoteException {
        return this.zzb.zzJ().zza();
    }

    public final boolean zzG() {
        return this.zzb.zzB();
    }

    public final zzbgz zzH() throws RemoteException {
        zzbjd zzbjd2 = zzbjl.zzfb;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) != false) return this.zzb.zzm();
        return null;
    }

    public final void zzI(zzbgw zzbgw2) throws RemoteException {
        this.zzb.zzK(zzbgw2);
    }

    public final String zze() throws RemoteException {
        return this.zzc.zzz();
    }

    public final List<?> zzf() throws RemoteException {
        return this.zzc.zzA();
    }

    public final String zzg() throws RemoteException {
        return this.zzc.zzE();
    }

    public final zzbmh zzh() throws RemoteException {
        return this.zzc.zzN();
    }

    public final String zzi() throws RemoteException {
        return this.zzc.zzG();
    }

    public final String zzj() throws RemoteException {
        return this.zzc.zzO();
    }

    public final double zzk() throws RemoteException {
        return this.zzc.zzM();
    }

    public final String zzl() throws RemoteException {
        return this.zzc.zzK();
    }

    public final String zzm() throws RemoteException {
        return this.zzc.zzL();
    }

    public final zzbhc zzn() throws RemoteException {
        return this.zzc.zzw();
    }

    public final String zzo() throws RemoteException {
        return this.zza;
    }

    public final void zzp() throws RemoteException {
        this.zzb.zzT();
    }

    public final zzblz zzq() throws RemoteException {
        return this.zzc.zzx();
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        this.zzb.zzf(bundle);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        return this.zzb.zzg(bundle);
    }

    public final void zzt(Bundle bundle) throws RemoteException {
        this.zzb.zzh(bundle);
    }

    public final IObjectWrapper zzu() throws RemoteException {
        return ObjectWrapper.wrap((Object)this.zzb);
    }

    public final IObjectWrapper zzv() throws RemoteException {
        return this.zzc.zzJ();
    }

    public final Bundle zzw() throws RemoteException {
        return this.zzc.zzF();
    }

    public final void zzx(zzbob zzbob2) throws RemoteException {
        this.zzb.zzv(zzbob2);
    }

    public final void zzy() throws RemoteException {
        this.zzb.zzw();
    }

    public final List<?> zzz() throws RemoteException {
        List list = this.zzA() ? this.zzc.zzC() : Collections.emptyList();
        return list;
    }
}
