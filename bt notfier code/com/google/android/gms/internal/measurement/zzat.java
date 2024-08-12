/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.internal.measurement.zzn
 *  com.google.android.gms.internal.measurement.zzq
 *  com.google.android.gms.internal.measurement.zzt
 */
package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzt;

final class zzat
extends zzbh {
    final String zza;
    final String zzb;
    final boolean zzc;
    final zzn zzd;
    final zzbs zze;

    zzat(zzbs zzbs2, String string, String string2, boolean bl, zzn zzn2) {
        this.zze = zzbs2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = bl;
        this.zzd = zzn2;
        super(zzbs2, true);
    }

    final void zza() throws RemoteException {
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zze))).getUserProperties(this.zza, this.zzb, this.zzc, (zzt)this.zzd);
    }

    protected final void zzb() {
        this.zzd.zzb(null);
    }
}
