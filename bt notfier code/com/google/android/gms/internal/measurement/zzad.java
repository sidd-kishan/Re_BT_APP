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

final class zzad
extends zzbh {
    final String zza;
    final String zzb;
    final zzn zzc;
    final zzbs zzd;

    zzad(zzbs zzbs2, String string, String string2, zzn zzn2) {
        this.zzd = zzbs2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = zzn2;
        super(zzbs2, true);
    }

    final void zza() throws RemoteException {
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzd))).getConditionalUserProperties(this.zza, this.zzb, (zzt)this.zzc);
    }

    protected final void zzb() {
        this.zzc.zzb(null);
    }
}
