/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzdba
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdbu
 *  com.google.android.gms.internal.ads.zzdcj
 *  com.google.android.gms.internal.ads.zzdco
 *  com.google.android.gms.internal.ads.zzddi
 *  com.google.android.gms.internal.ads.zzdfv
 *  com.google.android.gms.internal.ads.zzdfz
 *  com.google.android.gms.internal.ads.zzdim
 *  com.google.android.gms.internal.ads.zzdix
 *  com.google.android.gms.internal.ads.zzdjf
 *  com.google.android.gms.internal.ads.zzeje
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzdba;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdbu;
import com.google.android.gms.internal.ads.zzdcj;
import com.google.android.gms.internal.ads.zzdco;
import com.google.android.gms.internal.ads.zzddi;
import com.google.android.gms.internal.ads.zzdfv;
import com.google.android.gms.internal.ads.zzdfz;
import com.google.android.gms.internal.ads.zzdim;
import com.google.android.gms.internal.ads.zzdix;
import com.google.android.gms.internal.ads.zzdjf;
import com.google.android.gms.internal.ads.zzeje;

public class zzeid
extends zzeje {
    private final zzdix zza;

    public zzeid(zzdba zzdba2, zzdim zzdim2, zzdbu zzdbu2, zzdcj zzdcj2, zzdco zzdco2, zzdbp zzdbp2, zzdfz zzdfz2, zzdjf zzdjf2, zzddi zzddi2, zzdix zzdix2, zzdfv zzdfv2) {
        super(zzdba2, zzdim2, zzdbu2, zzdcj2, zzdco2, zzdfz2, zzddi2, zzdjf2, zzdfv2, zzdbp2);
        this.zza = zzdix2;
    }

    public final void zzn() {
        this.zza.zzc();
    }

    public final void zzo() {
        this.zza.zza();
    }

    public final void zzp(zzccl zzccl2) {
        this.zza.zzb(zzccl2);
    }

    public final void zzr(zzccp zzccp2) throws RemoteException {
        this.zza.zzb(new zzccl(zzccp2.zze(), zzccp2.zzf()));
    }

    public final void zzt() throws RemoteException {
        this.zza.zzc();
    }
}
