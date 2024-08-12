/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbj
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.internal.measurement.zzq
 *  com.google.android.gms.internal.measurement.zzw
 */
package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzw;

final class zzbd
extends zzbh {
    final zzbj zza;
    final zzbs zzb;

    zzbd(zzbs zzbs2, zzbj zzbj2) {
        this.zzb = zzbs2;
        this.zza = zzbj2;
        super(zzbs2, true);
    }

    final void zza() throws RemoteException {
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzb))).registerOnMeasurementEventListener((zzw)this.zza);
    }
}
