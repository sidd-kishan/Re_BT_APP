/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzccv
 *  com.google.android.gms.internal.ads.zzccz
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdwh
 *  com.google.android.gms.internal.ads.zzdwm
 *  com.google.android.gms.internal.ads.zzdwv
 *  com.google.android.gms.internal.ads.zzdww
 *  com.google.android.gms.internal.ads.zzezq
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzccz;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdwh;
import com.google.android.gms.internal.ads.zzdwm;
import com.google.android.gms.internal.ads.zzdwv;
import com.google.android.gms.internal.ads.zzdww;
import com.google.android.gms.internal.ads.zzezq;

public final class zzdwx
implements zzdwh {
    private final long zza;
    private final String zzb;
    private final zzdwm zzc;
    private final zzezq zzd;

    zzdwx(long l, Context context, zzdwm zzdwm2, zzcoj zzcoj2, String string) {
        this.zza = l;
        this.zzb = string;
        this.zzc = zzdwm2;
        zzdwm2 = zzcoj2.zzt();
        zzdwm2.zzc(context);
        zzdwm2.zzb(string);
        this.zzd = zzdwm2.zza().zzb();
    }

    static /* synthetic */ long zzd(zzdwx zzdwx2) {
        return zzdwx2.zza;
    }

    static /* synthetic */ zzdwm zze(zzdwx zzdwx2) {
        return zzdwx2.zzc;
    }

    public final void zza(zzbdg zzbdg2) {
        try {
            zzezq zzezq2 = this.zzd;
            zzdwv zzdwv2 = new zzdwv(this);
            zzezq2.zzc(zzbdg2, (zzccz)zzdwv2);
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzb() {
        try {
            zzezq zzezq2 = this.zzd;
            zzdww zzdww2 = new zzdww(this);
            zzezq2.zze((zzccv)zzdww2);
            this.zzd.zzb(ObjectWrapper.wrap(null));
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzc() {
    }
}
