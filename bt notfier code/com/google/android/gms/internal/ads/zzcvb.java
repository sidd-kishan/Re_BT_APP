/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzaxv
 *  com.google.android.gms.internal.ads.zzaya
 *  com.google.android.gms.internal.ads.zzayd
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcva
 *  com.google.android.gms.internal.ads.zzevv
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzaya;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcva;
import com.google.android.gms.internal.ads.zzevv;

public final class zzcvb
extends zzaxv {
    private final zzcva zza;
    private final zzbfn zzb;
    private final zzevv zzc;
    private boolean zzd = false;

    public zzcvb(zzcva zzcva2, zzbfn zzbfn2, zzevv zzevv2) {
        this.zza = zzcva2;
        this.zzb = zzbfn2;
        this.zzc = zzevv2;
    }

    public final zzbfn zze() {
        return this.zzb;
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzayd zzayd2) {
        try {
            this.zzc.zzi(zzayd2);
            this.zza.zzb((Activity)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), zzayd2, this.zzd);
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final zzbgz zzg() {
        zzbjd zzbjd2 = zzbjl.zzfb;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) != false) return this.zza.zzm();
        return null;
    }

    public final void zzh(boolean bl) {
        this.zzd = bl;
    }

    public final void zzi(zzbgw zzbgw2) {
        Preconditions.checkMainThread((String)"setOnPaidEventListener must be called on the main UI thread.");
        zzevv zzevv2 = this.zzc;
        if (zzevv2 == null) return;
        zzevv2.zzl(zzbgw2);
    }

    public final void zzj(zzaya zzaya2) {
    }
}
