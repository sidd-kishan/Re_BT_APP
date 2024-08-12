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

final class zzac
extends zzbh {
    final String zza;
    final String zzb;
    final Bundle zzc;
    final zzbs zzd;

    zzac(zzbs zzbs2, String string, String string2, Bundle bundle) {
        this.zzd = zzbs2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = bundle;
        super(zzbs2, true);
    }

    final void zza() throws RemoteException {
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzd))).clearConditionalUserProperty(this.zza, this.zzb, this.zzc);
    }
}
