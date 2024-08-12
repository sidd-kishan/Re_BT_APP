/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.internal.measurement.zzq
 */
package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzq;

final class zzbg
extends zzbh {
    final String zza;
    final String zzb;
    final Object zzc;
    final boolean zzd;
    final zzbs zze;

    zzbg(zzbs zzbs2, String string, String string2, Object object, boolean bl) {
        this.zze = zzbs2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = object;
        this.zzd = bl;
        super(zzbs2, true);
    }

    final void zza() throws RemoteException {
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zze))).setUserProperty(this.zza, this.zzb, ObjectWrapper.wrap((Object)this.zzc), this.zzd, this.zzh);
    }
}
