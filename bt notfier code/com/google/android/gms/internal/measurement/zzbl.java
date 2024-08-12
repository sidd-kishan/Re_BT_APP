/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbr
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.internal.measurement.zzq
 */
package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzq;

final class zzbl
extends zzbh {
    final Activity zza;
    final zzbr zzb;

    zzbl(zzbr zzbr2, Activity activity) {
        this.zzb = zzbr2;
        this.zza = activity;
        super(zzbr2.zza, true);
    }

    final void zza() throws RemoteException {
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzb.zza))).onActivityStarted(ObjectWrapper.wrap((Object)this.zza), this.zzi);
    }
}
