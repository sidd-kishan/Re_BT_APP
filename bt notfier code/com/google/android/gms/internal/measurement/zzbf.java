/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.internal.measurement.zzq
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzq;

final class zzbf
extends zzbh {
    final Long zza;
    final String zzb;
    final String zzc;
    final Bundle zzd;
    final boolean zze;
    final boolean zzf;
    final zzbs zzg;

    zzbf(zzbs zzbs2, Long l, String string, String string2, Bundle bundle, boolean bl, boolean bl2) {
        this.zzg = zzbs2;
        this.zza = l;
        this.zzb = string;
        this.zzc = string2;
        this.zzd = bundle;
        this.zze = bl;
        this.zzf = bl2;
        super(zzbs2, true);
    }

    final void zza() throws RemoteException {
        Long l = this.zza;
        long l2 = l == null ? this.zzh : l;
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzg))).logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, l2);
    }
}
