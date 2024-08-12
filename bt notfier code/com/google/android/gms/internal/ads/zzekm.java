/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbff
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzelt
 *  com.google.android.gms.internal.ads.zzelv
 *  com.google.android.gms.internal.ads.zzely
 *  com.google.android.gms.internal.ads.zzemf
 *  com.google.android.gms.internal.ads.zzfap
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzelt;
import com.google.android.gms.internal.ads.zzelv;
import com.google.android.gms.internal.ads.zzely;
import com.google.android.gms.internal.ads.zzemf;
import com.google.android.gms.internal.ads.zzfap;

public final class zzekm
extends zzbff {
    private final zzelt zza;

    public zzekm(Context context, zzcoj zzcoj2, zzfap zzfap2, zzdmx zzdmx2, zzbfa zzbfa2) {
        zzdmx2 = new zzelv(zzdmx2, zzcoj2.zzd());
        zzdmx2.zza(zzbfa2);
        this.zza = new zzelt((zzely)new zzemf(zzcoj2, context, (zzelv)zzdmx2, zzfap2), zzfap2.zzx());
    }

    public final void zze(zzbdg zzbdg2) throws RemoteException {
        this.zza.zzc(zzbdg2, 1);
    }

    public final String zzf() {
        synchronized (this) {
            String string = this.zza.zzd();
            return string;
        }
    }

    public final boolean zzg() throws RemoteException {
        synchronized (this) {
            boolean bl = this.zza.zzb();
            return bl;
        }
    }

    public final String zzh() {
        synchronized (this) {
            String string = this.zza.zze();
            return string;
        }
    }

    public final void zzi(zzbdg zzbdg2, int n) throws RemoteException {
        synchronized (this) {
            this.zza.zzc(zzbdg2, n);
            return;
        }
    }
}
