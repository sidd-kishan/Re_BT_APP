/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.RemoteException
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzcaf
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzfrz;

final class zzt
implements zzfrz<Uri> {
    final zzcaf zza;
    final zzv zzb;

    zzt(zzv zzv2, zzcaf zzcaf2) {
        this.zzb = zzv2;
        this.zza = zzcaf2;
    }

    public final void zza(Throwable object) {
        try {
            zzcaf zzcaf2 = this.zza;
            object = String.valueOf(((Throwable)object).getMessage());
            object = ((String)object).length() != 0 ? "Internal error: ".concat((String)object) : new String("Internal error: ");
            zzcaf2.zzf((String)object);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }
}
