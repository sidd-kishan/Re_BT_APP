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

final class zzau
extends zzbh {
    final String zza;
    final Object zzb;
    final zzbs zzc;

    zzau(zzbs zzbs2, boolean bl, int n, String string, Object object, Object object2, Object object3) {
        this.zzc = zzbs2;
        this.zza = string;
        this.zzb = object;
        super(zzbs2, false);
    }

    final void zza() throws RemoteException {
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzc))).logHealthData(5, this.zza, ObjectWrapper.wrap((Object)this.zzb), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
    }
}
