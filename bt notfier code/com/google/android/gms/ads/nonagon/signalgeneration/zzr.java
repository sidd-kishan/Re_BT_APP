/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzah
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzcfk
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzah;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzfrz;

final class zzr
implements zzfrz<zzah> {
    final zzcfk zza;
    final zzv zzb;

    zzr(zzv zzv2, zzcfk zzcfk2) {
        this.zzb = zzv2;
        this.zza = zzcfk2;
    }

    public final void zza(Throwable object) {
        String string = ((Throwable)object).getMessage();
        zzt.zzg().zzk((Throwable)object, "SignalGeneratorImpl.generateSignals");
        zzv.zzy((zzv)this.zzb, (String)"sgf", (String)"sgf_reason", (String)string);
        try {
            zzcfk zzcfk2 = this.zza;
            object = String.valueOf(string);
            object = ((String)object).length() != 0 ? "Internal error. ".concat((String)object) : new String("Internal error. ");
            zzcfk2.zzb((String)object);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }
}
