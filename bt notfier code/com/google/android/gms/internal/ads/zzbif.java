/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzbgd
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbie
 *  com.google.android.gms.internal.ads.zzbim
 *  com.google.android.gms.internal.ads.zzbrl
 *  com.google.android.gms.internal.ads.zzbrs
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbie;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.Collections;
import java.util.List;

public final class zzbif
extends zzbgd {
    private zzbrs zza;

    final /* synthetic */ void zzb() {
        zzbrs zzbrs2 = this.zza;
        if (zzbrs2 == null) return;
        try {
            zzbrs2.zzb(Collections.emptyList());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Could not notify onComplete event.", (Throwable)remoteException);
        }
    }

    public final void zze() throws RemoteException {
        zzcgt.zzf((String)"The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzcgm.zza.post((Runnable)new zzbie(this));
    }

    public final void zzf(float f) throws RemoteException {
    }

    public final void zzg(String string) throws RemoteException {
    }

    public final void zzh(boolean bl) throws RemoteException {
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String string) throws RemoteException {
    }

    public final void zzj(String string, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final float zzk() throws RemoteException {
        return 1.0f;
    }

    public final boolean zzl() throws RemoteException {
        return false;
    }

    public final String zzm() {
        return "";
    }

    public final void zzn(String string) throws RemoteException {
    }

    public final void zzo(zzbvg zzbvg2) throws RemoteException {
    }

    public final void zzp(zzbrs zzbrs2) throws RemoteException {
        this.zza = zzbrs2;
    }

    public final List<zzbrl> zzq() throws RemoteException {
        return Collections.emptyList();
    }

    public final void zzr(zzbim zzbim2) throws RemoteException {
    }

    public final void zzs() {
    }

    public final void zzt(zzbgq zzbgq2) {
    }
}
