/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.internal.measurement.zzq
 */
package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzq;

final class zzag
extends zzbh {
    final Boolean zza;
    final zzbs zzb;

    zzag(zzbs zzbs2, Boolean bl) {
        this.zzb = zzbs2;
        this.zza = bl;
        super(zzbs2, true);
    }

    final void zza() throws RemoteException {
        if (this.zza != null) {
            ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzb))).setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
            return;
        }
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzb))).clearMeasurementEnabled(this.zzh);
    }
}
