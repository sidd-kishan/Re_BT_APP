/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfd
 *  com.google.android.gms.internal.ads.zzbfm
 *  com.google.android.gms.internal.ads.zzbfr
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzbgb
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhg
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzbzz
 *  com.google.android.gms.internal.ads.zzcac
 *  com.google.android.gms.internal.ads.zzccf
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzeli
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfav
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbzz;
import com.google.android.gms.internal.ads.zzcac;
import com.google.android.gms.internal.ads.zzccf;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzeli;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfav;
import java.util.Collections;

public final class zzekj
extends zzbfm {
    private final Context zza;
    private final zzbfa zzb;
    private final zzfar zzc;
    private final zzcvh zzd;
    private final ViewGroup zze;

    public zzekj(Context context, zzbfa zzbfa2, zzfar zzfar2, zzcvh zzcvh2) {
        this.zza = context;
        this.zzb = zzbfa2;
        this.zzc = zzfar2;
        this.zzd = zzcvh2;
        context = new FrameLayout(this.zza);
        context.removeAllViews();
        context.addView(this.zzd.zza(), zzt.zze().zzj());
        context.setMinimumHeight(this.zzu().zzc);
        context.setMinimumWidth(this.zzu().zzf);
        this.zze = context;
    }

    public final zzbgz zzA() {
        return this.zzd.zzm();
    }

    public final String zzB() throws RemoteException {
        return this.zzc.zzf;
    }

    public final zzbfu zzC() throws RemoteException {
        return this.zzc.zzn;
    }

    public final zzbfa zzD() throws RemoteException {
        return this.zzb;
    }

    public final void zzE(zzbkg zzbkg2) throws RemoteException {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzF(zzbex zzbex2) throws RemoteException {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzG(boolean bl) throws RemoteException {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final boolean zzH() throws RemoteException {
        return false;
    }

    public final void zzI(zzccf zzccf2) throws RemoteException {
    }

    public final void zzJ(String string) throws RemoteException {
    }

    public final void zzK(String string) throws RemoteException {
    }

    public final zzbhc zzL() throws RemoteException {
        return this.zzd.zzc();
    }

    public final void zzM(zzbis zzbis2) throws RemoteException {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzN(zzbhg zzbhg2) throws RemoteException {
    }

    public final void zzO(zzbdr zzbdr2) throws RemoteException {
    }

    public final void zzP(zzaxz zzaxz2) throws RemoteException {
    }

    public final void zzQ(boolean bl) throws RemoteException {
    }

    public final void zzX(zzbgw zzbgw2) {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzY(zzbdg zzbdg2, zzbfd zzbfd2) {
    }

    public final void zzZ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzaa(zzbgb zzbgb2) {
    }

    public final void zzab(zzbfy zzbfy2) throws RemoteException {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final IObjectWrapper zzi() throws RemoteException {
        return ObjectWrapper.wrap((Object)this.zze);
    }

    public final void zzj() throws RemoteException {
        Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
        this.zzd.zzT();
    }

    public final boolean zzk() throws RemoteException {
        return false;
    }

    public final boolean zzl(zzbdg zzbdg2) throws RemoteException {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    public final void zzm() throws RemoteException {
        Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
        this.zzd.zzl().zza(null);
    }

    public final void zzn() throws RemoteException {
        Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
        this.zzd.zzl().zzb(null);
    }

    public final void zzo(zzbfa zzbfa2) throws RemoteException {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzp(zzbfu zzbfu2) throws RemoteException {
        zzeli zzeli2 = this.zzc.zzc;
        if (zzeli2 == null) return;
        zzeli2.zzp(zzbfu2);
    }

    public final void zzq(zzbfr zzbfr2) throws RemoteException {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final Bundle zzr() throws RemoteException {
        com.google.android.gms.ads.internal.util.zze.zzh((String)"getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    public final void zzs() throws RemoteException {
    }

    public final void zzt() throws RemoteException {
        this.zzd.zzh();
    }

    public final zzbdl zzu() {
        Preconditions.checkMainThread((String)"getAdSize must be called on the main UI thread.");
        return zzfav.zzb((Context)this.zza, Collections.singletonList(this.zzd.zze()));
    }

    public final void zzv(zzbdl zzbdl2) throws RemoteException {
        Preconditions.checkMainThread((String)"setAdSize must be called on the main UI thread.");
        zzcvh zzcvh2 = this.zzd;
        if (zzcvh2 == null) return;
        zzcvh2.zzb(this.zze, zzbdl2);
    }

    public final void zzw(zzbzz zzbzz2) throws RemoteException {
    }

    public final void zzx(zzcac zzcac2, String string) throws RemoteException {
    }

    public final String zzy() throws RemoteException {
        if (this.zzd.zzm() == null) return null;
        return this.zzd.zzm().zze();
    }

    public final String zzz() throws RemoteException {
        if (this.zzd.zzm() == null) return null;
        return this.zzd.zzm().zze();
    }
}
