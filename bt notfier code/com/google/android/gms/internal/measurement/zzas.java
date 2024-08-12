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

final class zzas
extends zzbh {
    final zzn zza;
    final zzbs zzb;

    zzas(zzbs zzbs2, zzn zzn2) {
        this.zzb = zzbs2;
        this.zza = zzn2;
        super(zzbs2, true);
    }

    final void zza() throws RemoteException {
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzb))).getCurrentScreenClass((zzt)this.zza);
    }

    protected final void zzb() {
        this.zza.zzb(null);
    }
}
